package com.dyne.viid.controller;

import cn.hutool.core.util.StrUtil;
import com.dyne.viid.common.annotation.LogOperation;
import com.dyne.viid.common.annotation.RequireAuth;
import com.dyne.viid.common.constant.Constants;
import com.dyne.viid.common.result.ConfirmStatusType;
import com.dyne.viid.common.result.ResponseStatusObject;
import com.dyne.viid.common.result.SystemTimeObject;
import com.dyne.viid.common.utils.DigestUtils;
import com.dyne.viid.common.validator.ValidatorUtils;
import com.dyne.viid.entity.DigestAuthInfo;
import com.dyne.viid.entity.VmsDevice;
import com.dyne.viid.entity.dto.KeepaliveObject;
import com.dyne.viid.entity.dto.RegisterObject;
import com.dyne.viid.entity.dto.UnRegisterObject;
import com.dyne.viid.service.VmsDeviceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * 公共功能相关接口
 */
@RestController
@Api(tags = "公共功能相关接口")
@RequestMapping(value = "/VIID")
@Slf4j
public class CommonController {

    @Autowired
    private VmsDeviceService vmsDeviceService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    private static final String DIGEST_TEMPLATE = "Digest realm=\"{}\",nonce=\"{}\",qop=\"auth\"";
    private static final String TEMPLATE_TWO = "{}:{}";
    private static final String TEMPLATE_THREE = "{}:{}:{}";
    private static final String TEMPLATE_FOUR = "{}:{}:{}:{}";
    private static final String HEADER = "WWW-Authenticate";


    @Value("${spring.http.digest.relam}")
    private String relam;

    @Value("${viid.aps-id}")
    private String apsId;


    @RequireAuth
    @PostMapping("/System/Register")
    @ApiOperation("注册")
    @LogOperation("注册")
    public ResponseStatusObject register(HttpServletRequest request, HttpServletResponse response, @RequestBody RegisterObject registerObject) {
//        log.info("register:{}", registerObjectStr);

//        JSONObject jsonObject = JSON.parseObject(registerObjectStr);
//        RegisterObject registerObject = jsonObject.getObject("RegisterObject", RegisterObject.class);
//        log.info("registerObject:{}", registerObject);
//        if (registerObject == null) {
//            registerObject = jsonObject.getObject("Register", RegisterObject.class);
//            log.info("registerObject:{}", registerObject);
//        }
        // 检验参数
        ValidatorUtils.validateEntity(registerObject);
        String deviceId = registerObject.getDeviceId();
        String authStr = request.getHeader(Constants.AUTHORIZATION);
        log.info("authStr:{}", authStr);
        DigestAuthInfo authObject = DigestUtils.getAuthInfoObject(authStr);
        // 解析 Digest 异常
        if (authObject == null) {
            return challenge(response);
        }
        /*
         * 生成 response 的算法：
         *  response = MD5(MD5(username:realm:password):nonce:nc:cnonce:qop:MD5(<request-method>:url))
         */
        VmsDevice vmsDevice = vmsDeviceService.getByDeviceID(deviceId);
        log.info("vms device:{}", vmsDevice);
        // 设备不存在，开启质询
        if (vmsDevice == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return ResponseStatusObject.create(ConfirmStatusType.Device_Error);
        }
        // 用户名错误
        if (!authObject.getUsername().equals(vmsDevice.getUserId())) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return ResponseStatusObject.create(ConfirmStatusType.Device_Error);
        }
        String HA1 = DigestUtils.md5(StrUtil.format(TEMPLATE_THREE, authObject.getUsername(), authObject.getRealm(), vmsDevice.getPassword()));
        log.info("authObj:{}", authObject);
        String HD = StrUtil.format(TEMPLATE_FOUR, authObject.getNonce(), authObject.getNc(), authObject.getCnonce(), authObject.getQop());
        HD = HD.replace(":null", "");
        String HA2 = DigestUtils.md5(StrUtil.format(TEMPLATE_TWO, request.getMethod(), authObject.getUri()));
        log.info(StrUtil.format(TEMPLATE_THREE, HA1, HD, HA2));
        String responseValid = DigestUtils.md5(StrUtil.format(TEMPLATE_THREE, HA1, HD, HA2));
        // 如果 Authorization 中的 response（浏览器生成的） 与期望的 response（服务器计算的） 相同，则验证通过
        log.info("Authorization 中的 response: " + authObject.getResponse());
        log.info("期望的 response: " + responseValid);
        if (responseValid.equals(authObject.getResponse())) {
            redisTemplate.opsForValue().set(Constants.KEEP_ALIVE + deviceId, deviceId, Constants.TOKEN_EXPIRE, TimeUnit.SECONDS);
        } else {
            challenge(response);
        }

        ResponseStatusObject responseStatusObject = ResponseStatusObject.create(ConfirmStatusType.OK);
        responseStatusObject.setId(deviceId);
        vmsDeviceService.onLineByDeviceId(deviceId, System.currentTimeMillis());
        return responseStatusObject;
    }

    private ResponseStatusObject challenge(HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        String header = StrUtil.format(DIGEST_TEMPLATE, relam, DigestUtils.generateToken());
        response.addHeader(HEADER, header);
        return null;
    }

    @RequireAuth
    @PostMapping("/System/UnRegister")
    @LogOperation("注销")
    public ResponseStatusObject unRegister(@RequestBody UnRegisterObject unRegisterObject) {
        ValidatorUtils.validateEntity(unRegisterObject);
        redisTemplate.delete(unRegisterObject.getDeviceId());
        String deviceId = unRegisterObject.getDeviceId();
        vmsDeviceService.offLineByDeviceId(deviceId);
        return ResponseStatusObject.create(ConfirmStatusType.OK);
    }

    @RequireAuth
    @PostMapping("/System/Keepalive")
    @LogOperation("保活")
    public ResponseStatusObject keepalive(@RequestBody KeepaliveObject keepaliveObject) {
        ValidatorUtils.validateEntity(keepaliveObject);
        String deviceId = keepaliveObject.getDeviceId();
        vmsDeviceService.keepByDeviceId(deviceId, System.currentTimeMillis());
        return ResponseStatusObject.create(ConfirmStatusType.OK);
    }

    @RequireAuth
    @GetMapping("/System/Time")
    @LogOperation("校时")
    public SystemTimeObject Time(HttpServletRequest request) {
        log.info("校时接口:{}", request.getHeader(Constants.USER_IDENTIFY));
        return new SystemTimeObject(apsId);
    }
}
