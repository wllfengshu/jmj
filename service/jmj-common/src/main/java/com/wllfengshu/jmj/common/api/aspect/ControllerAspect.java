package com.wllfengshu.jmj.common.api.aspect;

import com.alibaba.fastjson.JSON;
import com.wllfengshu.jmj.common.entity.gateway.GatewayRequest;
import com.wllfengshu.jmj.common.entity.gateway.constant.GatewayConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 控制器切面（用于把网关数据放到header里面的数据，放入控制器层的入参里）
 *
 * @author wangll
 * @date 2022-05-07 23:55
 */
@Slf4j
@Aspect
@Configuration
public class ControllerAspect {

    @Around("execution( * com.wllfengshu.jmj.provider.*.service..*.*(..))")
    public Object setupUserInfo(ProceedingJoinPoint pjp) throws Throwable {
        // 获取方法参数值数组
        Object[] paramArray = pjp.getArgs();
        // 获取方法参数类型数组
        Class<?>[] paramTypeArray = ((MethodSignature) pjp.getSignature()).getParameterTypes();
        if (ArrayUtils.isEmpty(paramArray)
            || ArrayUtils.isEmpty(paramTypeArray)) {
            return returnAndSaveResponseLog(pjp.proceed());
        }
        log.info("[request] = {}", JSON.toJSONString(paramArray));

        // 只允许一个入参，否则不处理
        if (paramTypeArray.length != 1) {
            return returnAndSaveResponseLog(pjp.proceed());
        }
        // 必须是GatewayEntity的子类，否则不处理
        if (!GatewayRequest.class.isAssignableFrom(paramTypeArray[0])) {
            return returnAndSaveResponseLog(pjp.proceed());
        }

        // 给入参赋值
        Object inputObject = paramArray[0];
        Class<?> inputClass = paramTypeArray[0];
        if (null == inputObject) {
            inputObject = inputClass.getDeclaredConstructor().newInstance();
        }
        GatewayRequest gatewayRequest = this.giveGatewayEntity();
        BeanCopier beanCopier = BeanCopier.create(GatewayRequest.class, GatewayRequest.class, false);
        beanCopier.copy(gatewayRequest, inputObject, null);

        paramArray[0] = inputObject;
        Object result = pjp.proceed(paramArray);
        return returnAndSaveResponseLog(result);
    }

    /**
     * 记录响应日志
     *
     * @param result
     * @return
     */
    private Object returnAndSaveResponseLog(Object result) {
        if (null == result) {
            return null;
        }
        log.info("[response] = {}", JSON.toJSONString(result));
        return result;
    }

    /**
     * 获取gateway请求信息
     *
     * @return
     */
    private GatewayRequest giveGatewayEntity() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (null == requestAttributes) {
            log.error("[giveGatewayEntity error, requestAttributes is null]");
            return new GatewayRequest();
        }
        HttpServletRequest request = requestAttributes.getRequest();
        String loginInfo = request.getHeader(GatewayConstant.LOGIN_INFO);
        GatewayRequest gatewayRequest = JSON.parseObject(loginInfo, GatewayRequest.class);
        if (null == gatewayRequest) {
            log.error("[giveGatewayEntity error, gatewayRequest is null]");
            return new GatewayRequest();
        }
        return gatewayRequest;
    }

}
