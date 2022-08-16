package com.dyne.viid.interceptor;

import com.dyne.viid.common.constant.Constants;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 权限验证
 */
@Component
@Slf4j
public class LoginAuthInterceptor implements HandlerInterceptor {

    private static StringRedisTemplate stringRedisTemplate;

    @Autowired
    private void setRedis(StringRedisTemplate redisTemplate) {
        LoginAuthInterceptor.stringRedisTemplate = redisTemplate;
    }


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        log.info("login check ...");
        String authStr = request.getHeader(Constants.AUTHORIZATION);
        if (StringUtils.isNotBlank(authStr)) {
            String username = stringRedisTemplate.opsForValue().get(Constants.USER_TOKEN + authStr);
            return StringUtils.isNotBlank(username);
        }
        response.setStatus(403);
        return false;
    }

}
