package com.dyne.viid.interceptor;

import cn.hutool.core.util.StrUtil;
import com.dyne.viid.common.annotation.RequireAuth;
import com.dyne.viid.common.constant.Constants;
import com.dyne.viid.common.utils.DigestUtils;
import com.dyne.viid.entity.DigestAuthInfo;
import com.dyne.viid.entity.VmsDevice;
import com.dyne.viid.service.VmsDeviceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * 权限验证
 * 注册成功 才会携带请求头User-Identify
 */
@Component
@Slf4j
public class AuthorizationInterceptor implements HandlerInterceptor {

//    @Autowired
//    private StringRedisTemplate redisTemplate;

    private static String relam;

    @Value("${spring.http.digest.relam}")
    public void setClientHostUrl(String relam) {
        AuthorizationInterceptor.relam = relam;
    }

    private static final String TEMPLATE_TWO = "{}:{}";
    private static final String TEMPLATE_THREE = "{}:{}:{}";
    private static final String TEMPLATE_FOUR = "{}:{}:{}:{}";
    private static final String DIGEST_TEMPLATE = "Digest realm=\"{}\",nonce=\"{}\",qop=\"auth\"";
    private static final String HEADER = "WWW-Authenticate";


    private static VmsDeviceService vmsDeviceService;

    private static StringRedisTemplate stringRedisTemplate;

    @Autowired
    private void setVmsApeService(VmsDeviceService vmsDeviceService, StringRedisTemplate redisTemplate) {
        AuthorizationInterceptor.vmsDeviceService = vmsDeviceService;
        AuthorizationInterceptor.stringRedisTemplate = redisTemplate;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        RequireAuth annotation;
        if (handler instanceof HandlerMethod) {
            annotation = ((HandlerMethod) handler).getMethodAnnotation(RequireAuth.class);
        } else {
            return true;
        }

        if (annotation == null) {
            return true;
        }

        // 没有 Authorization 请求头，或者 Authorization 认证信息验证不通过，拦截
        if (!isAuth(request, response)) {
            return false;
        }
        return true;
    }

    private boolean isAuth(HttpServletRequest request, HttpServletResponse response) {
        // 根据用户名查询存储的密码
        String userIdentify = request.getHeader(Constants.USER_IDENTIFY);
        log.info("userIdentify:{}", userIdentify);
        if (StringUtils.isNotBlank(userIdentify)) {
            String requestURI = request.getRequestURI();
            log.info("URI:{}", requestURI);
            if (requestURI.equals("/VIID/Subscribes")) {
                if (StringUtils.isBlank(stringRedisTemplate.opsForValue().get(Constants.SERVER_kEY + userIdentify))) {
                    return false;
                }
            }
            String deviceId = stringRedisTemplate.opsForValue().get(Constants.KEEP_ALIVE + userIdentify);
//            String deviceId = LocalCacheUtil.get(userIdentify);
            if (StringUtils.isNotBlank(deviceId)) {
                log.info("{}缓存命中，通过, 续期", deviceId);
                stringRedisTemplate.opsForValue().set(Constants.KEEP_ALIVE + userIdentify, userIdentify, Constants.TOKEN_EXPIRE, TimeUnit.SECONDS);
                return true;
            }
        } else {
            return false;
        }

        String authStr = request.getHeader(Constants.AUTHORIZATION);
        log.info("请求 Authorization 的内容：" + authStr);
        if (authStr == null || authStr.length() <= DigestUtils.HEAD.length()) {
            // 没有 Authorization 请求头，开启质询
            return challenge(response);
        }

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


        VmsDevice vmsDevice = vmsDeviceService.getByDeviceID(userIdentify);
        log.info("vms device:{}", vmsDevice);
        // 设备不存在，开启质询
        if (vmsDevice == null) {
            return challenge(response);
        }
        // 用户名错误
        if (!authObject.getUsername().equals(vmsDevice.getUserId())) {
            return challenge(response);
        }
        String HA1 = DigestUtils.md5(StrUtil.format(TEMPLATE_THREE, authObject.getUsername(), authObject.getRealm(), vmsDevice.getPassword()));
        log.info("authObj:{}", authObject);
        String HD = StrUtil.format(TEMPLATE_FOUR, authObject.getNonce(), authObject.getNc(), authObject.getCnonce(), authObject.getQop());
        log.info("HD:{}", HD);
        String HA2 = DigestUtils.md5(StrUtil.format(TEMPLATE_TWO, request.getMethod(), authObject.getUri()));
        log.info(StrUtil.format(TEMPLATE_THREE, HA1, HD, HA2));
        String responseValid = DigestUtils.md5(StrUtil.format(TEMPLATE_THREE, HA1, HD, HA2));
        // 如果 Authorization 中的 response（浏览器生成的） 与期望的 response（服务器计算的） 相同，则验证通过
        log.info("Authorization 中的 response: " + authObject.getResponse());
        log.info("期望的 response: " + responseValid);
        if (responseValid.equals(authObject.getResponse())) {
            stringRedisTemplate.opsForValue().set(Constants.KEEP_ALIVE + userIdentify, userIdentify, Constants.TOKEN_EXPIRE, TimeUnit.SECONDS);
            return true;
        }
        // 验证不通过，重复质询
        return challenge(response);
    }

    /**
     * 质询：返回状态码 401 和 WWW-Authenticate 响应头
     * 质询前，重置或删除保存的与该用户关联的 nc 值（nc：nonce计数器，是一个16进制的数值，表示同一nonce下客户端发送出请求的数量）
     * 将 nc 置为初始值 0， 这里代码省略
     *
     * @param response 响应
     * @return 返回false，则表示拦截器拦截请求
     */
    private boolean challenge(HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        String header = StrUtil.format(DIGEST_TEMPLATE, relam, DigestUtils.generateToken());
        response.addHeader(HEADER, header);
        return false;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        String authStr = "Digest username=\"32010100001190009999\",realm=\"32010100\", nonce=\"e0cb14f664fb15bb7f75a4ea6f843b31\", \n" +
                "qop=auth,uri=\"/VIID/System/Register\",algorithm=\"MD5\",response=\"\",nc=00000001,cnonce=\"123456789\"";
        log.info("请求 Authorization 的内容：" + authStr);


        DigestAuthInfo authObject = DigestUtils.getAuthInfoObject(authStr);

        /*
         * 生成 response 的算法：
         *  response = MD5(MD5(username:realm:password):nonce:nc:cnonce:qop:MD5(<request-method>:url))
         */
        // 根据用户名查询存储的密码

        String HA1 = DigestUtils.md5(StrUtil.format(TEMPLATE_THREE, authObject.getUsername(), authObject.getRealm(), "123456"));
        String HD = StrUtil.format(TEMPLATE_FOUR, authObject.getNonce(), authObject.getNc(), authObject.getCnonce(), authObject.getQop());
        String HA2 = DigestUtils.md5(StrUtil.format(TEMPLATE_TWO, "POST", authObject.getUri()));
        String responseValid = DigestUtils.md5(StrUtil.format(TEMPLATE_THREE, HA1, HD, HA2));
        // 如果 Authorization 中的 response（浏览器生成的） 与期望的 response（服务器计算的） 相同，则验证通过
        log.info("Authorization 中的 response: " + authObject.getResponse());
        log.info("期望的 response: " + responseValid);
    }

}
