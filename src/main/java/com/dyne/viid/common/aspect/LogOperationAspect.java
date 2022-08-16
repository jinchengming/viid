package com.dyne.viid.common.aspect;

import cn.hutool.json.JSONUtil;
import com.dyne.viid.common.annotation.LogOperation;
import com.dyne.viid.common.constant.Constants;
import com.dyne.viid.common.enums.OperationStatus;
import com.dyne.viid.common.utils.HttpContextUtils;
import com.dyne.viid.common.utils.IpUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 系统日志，切面处理类
 */
@Slf4j
@Aspect
@Component
public class LogOperationAspect {

    @Pointcut("@annotation(com.dyne.viid.common.annotation.LogOperation)")
    public void logPointCut() {

    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        try {
            //执行方法
            Object result = point.proceed();
            //执行时长(毫秒)
            long time = System.currentTimeMillis() - beginTime;
            //保存日志
            saveLog(point, time, OperationStatus.SUCCESS);
            log.info("返回结果:[{}]", JSONUtil.toJsonStr(result));
            return result;
        } catch (Exception e) {
            //执行时长(毫秒)
            long time = System.currentTimeMillis() - beginTime;
            //保存日志
            saveLog(point, time, OperationStatus.FAIL);
            e.printStackTrace();
            throw e;
        }
    }

    private void saveLog(ProceedingJoinPoint joinPoint, long time, OperationStatus status) throws Exception {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        LogOperation annotation = joinPoint.getTarget().getClass()
                .getDeclaredMethod(signature.getName(), signature.getParameterTypes())
                .getAnnotation(LogOperation.class);

        String info = StringUtils.EMPTY;
        if (annotation != null) {
            // 注解上的描述
            info = annotation.value();
        }

        // 请求相关信息
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        String ipAddr = IpUtils.getIpAddr(request);
        String uri = request.getRequestURI();
        String method = request.getMethod();
        String userIdentify = request.getHeader(Constants.USER_IDENTIFY);
        // 请求参数
        Object[] args = joinPoint.getArgs();
        String params = JSONUtil.toJsonStr(args.length > 0 ? args[0] : StringUtils.EMPTY);
        log.info("描述:[{}],操作用户:[{}],请求方法:[{}],请求地址:[{}],来源IP:[{}]", info, userIdentify, method, uri, ipAddr);
        log.info("执行结果:[{}],执行时长:[{}ms]", status.name(), time);
        log.info("请求参数:[{}]", params);

    }
}
