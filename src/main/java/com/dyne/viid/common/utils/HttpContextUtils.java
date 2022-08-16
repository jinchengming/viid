package com.dyne.viid.common.utils;

import cn.hutool.core.map.MapUtil;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.dyne.viid.common.constant.Constants;
import com.google.common.net.HttpHeaders;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Http上下文工具类
 */
public class HttpContextUtils {
    public static HttpServletRequest getHttpServletRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            return null;
        }

        return ((ServletRequestAttributes) requestAttributes).getRequest();
    }

    public static Map<String, String> getParameterMap(HttpServletRequest request) {
        Enumeration<String> parameters = request.getParameterNames();

        Map<String, String> params = new HashMap<>(MapUtil.DEFAULT_INITIAL_CAPACITY);
        while (parameters.hasMoreElements()) {
            String parameter = parameters.nextElement();
            String value = request.getParameter(parameter);
            if (StringUtils.isNotBlank(value)) {
                params.put(parameter, value);
            }
        }

        return params;
    }

    public static String getUserIdentify() {
        HttpServletRequest request = getHttpServletRequest();
        return request.getHeader(Constants.USER_IDENTIFY);
    }

    public static String getContentType() {
        HttpServletRequest request = getHttpServletRequest();
        return request.getContentType();
    }

    public static String getRequestUrl() {
        HttpServletRequest request = getHttpServletRequest();
        return request.getRequestURI();
    }

    public static String getDomain() {
        HttpServletRequest request = getHttpServletRequest();
        StringBuffer url = request.getRequestURL();
        return url.delete(url.length() - request.getRequestURI().length(), url.length()).toString();
    }

    public static String getOrigin() {
        HttpServletRequest request = getHttpServletRequest();
        return request.getHeader(HttpHeaders.ORIGIN);
    }

    public static String getLanguage() {
        // 默认语言
        String defaultLanguage = "zh-CN";
        // request
        HttpServletRequest request = getHttpServletRequest();
        if (request == null) {
            return defaultLanguage;
        }
        // 请求语言
        defaultLanguage = request.getHeader(HttpHeaders.ACCEPT_LANGUAGE);

        return defaultLanguage;
    }
}

