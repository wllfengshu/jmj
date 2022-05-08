package com.wllfengshu.jmj.provider.dice.aspect;

import com.alibaba.fastjson.JSON;
import com.wllfengshu.jmj.common.entity.gateway.GatewayEntity;
import com.wllfengshu.jmj.common.entity.gateway.constant.GatewayConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wangll
 * @date 2022-05-07 23:55
 */
@Slf4j
@Aspect
@Component
public class ControllerAspect {

    @Around("execution( * com.wllfengshu.jmj.provider.*.web..*.*(..))")
    public Object setupUserInfo(ProceedingJoinPoint pjp) throws Throwable {
        // 获取方法参数值数组
        Object[] paramArray = pjp.getArgs();
        log.info("[request1] = {}", JSON.toJSONString(paramArray));
        // 获取方法参数类型数组
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Class<?>[] paramTypeArray = methodSignature.getParameterTypes();
        log.info("[request2] = {}", JSON.toJSONString(paramTypeArray));
        if (ArrayUtils.isEmpty(paramArray)
            || ArrayUtils.isEmpty(paramTypeArray)) {
            return pjp.proceed();
        }
        log.info("[request] = {}", JSON.toJSONString(paramArray));
        // 只允许一个入参，否则不处理
        if (paramTypeArray.length != 1) {
            return pjp.proceed();
        }
        // 必须是GatewayEntity的子类，否则不处理
        if (!GatewayEntity.class.isAssignableFrom(paramTypeArray[0])) {
            return pjp.proceed();
        }

//
//        paramTypeArray[0]

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String loginInfo = request.getHeader(GatewayConstant.LOGIN_INFO);

//
//
//        for (int i = 0; i < paramArray.length; i++) {
//            for (int j = 0; j < pa; j++) {
//
//            }
//        }

        Object result = pjp.proceed(paramArray);
        log.info("响应结果为{}", JSON.toJSONString(result));
        return result;
    }

}
