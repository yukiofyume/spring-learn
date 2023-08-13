package com.dodo.http.log.aspect;

import com.dodo.http.log.annotation.WebLog;
import com.dodo.http.log.util.DateUtils;
import com.dodo.http.log.util.JacksonUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serial;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

/**
 * @author lwh
 * @date 2023-08-13 18:40:46
 * @describe --
 */
@Slf4j
@Aspect
@Component
public class WebLogPrintAspect {

    @Around("@within(webLog) || @annotation(webLog)")
    public Object printWebLog(ProceedingJoinPoint joinPoint, com.dodo.http.log.annotation.WebLog webLog) throws Throwable {
        LocalDateTime now = LocalDateTime.now();
        long startTime = DateUtils.toTimestamp(now);
        String beginTime = DateUtils.toString(now, DateUtils.NORM_DATETIME_PATTERN);
        Class<?> targetClazz = joinPoint.getTarget().getClass();
        String className = targetClazz.getName();
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String methodName = methodSignature.getName();
        Object result = null;
        try {
            result = joinPoint.proceed();
        } finally {
            Method targetMethod = targetClazz.getDeclaredMethod(methodSignature.getName(), methodSignature.getMethod().getParameterTypes());
            WebLog logAnnotation = Optional.ofNullable(targetMethod.getAnnotation(WebLog.class)).orElse(joinPoint.getTarget().getClass().getAnnotation(WebLog.class));
            if (Objects.nonNull(logAnnotation)) {
                WebLogPrintEntity webLogPrintEntity = new WebLogPrintEntity();
                webLogPrintEntity.setBeginTime(beginTime);
                if (logAnnotation.requestParams()) {
                    webLogPrintEntity.setRequestParams(buildRequestParams(joinPoint));
                }
                if (logAnnotation.responseValues()) {
                    webLogPrintEntity.setResponseValues(result);
                }
                log.info("[{}.{}], executeTime: {}ms, info: {}", className, methodName,
                        DateUtils.currentTimestamp() - startTime, JacksonUtils.toJson(webLogPrintEntity));

            }
        }
        return result;
    }

    private Object[] buildRequestParams(ProceedingJoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        Object[] printArgs = new Object[args.length];
        for (int i = 0; i < args.length; i++) {
            if ((args[i] instanceof HttpServletRequest) || args[i] instanceof HttpServletResponse) {
                continue;
            }
            if (args[i] instanceof byte[]) {
                printArgs[i] = "byte array";
            } else if (args[i] instanceof MultipartFile) {
                printArgs[i] = "file";
            } else {
                printArgs[i] = args[i];
            }
        }
        return printArgs;
    }

    @Data
    private static class WebLogPrintEntity implements Serializable {

        @Serial
        private static final long serialVersionUID = -6213574929333482126L;

        private String beginTime;

        private Object[] requestParams;

        private Object responseValues;
    }
}
