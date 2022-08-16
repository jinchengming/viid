package com.dyne.viid.controller;

import com.dyne.viid.common.annotation.LogOperation;
import com.dyne.viid.common.annotation.RequireAuth;
import com.dyne.viid.common.constant.Constants;
import com.dyne.viid.common.result.ConfirmStatusType;
import com.dyne.viid.common.result.ResponseStatusObject;
import com.dyne.viid.common.result.SystemTimeObject;
import com.dyne.viid.common.validator.ValidatorUtils;
import com.dyne.viid.entity.dto.KeepaliveObject;
import com.dyne.viid.entity.dto.RegisterObject;
import com.dyne.viid.entity.dto.UnRegisterObject;
import com.dyne.viid.service.VmsDeviceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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

    @RequireAuth
    @PostMapping("/System/Register")
    @ApiOperation("注册")
    @LogOperation("注册")
    public ResponseStatusObject register(@RequestBody RegisterObject registerObject) {
        // 检验参数
        ValidatorUtils.validateEntity(registerObject);
        ResponseStatusObject responseStatusObject = ResponseStatusObject.create(ConfirmStatusType.OK);
        String deviceId = registerObject.getDeviceId();
        responseStatusObject.setId(deviceId);
        vmsDeviceService.onLineByDeviceId(deviceId);
        return responseStatusObject;
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
        return ResponseStatusObject.create(ConfirmStatusType.OK);
    }

    @RequireAuth
    @GetMapping("/System/Time")
    @LogOperation("校时")
    public SystemTimeObject Time(HttpServletRequest request) {
        log.info("校时接口:{}", request.getHeader(Constants.USER_IDENTIFY));
        return new SystemTimeObject("32010400005000000001");
    }
}
