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
import org.springframework.cglib.beans.BeanCopier;
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
        // 获取方法参数类型数组
        Class<?>[] paramTypeArray = ((MethodSignature) pjp.getSignature()).getParameterTypes();
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

        // 给入参赋值
        Object inputObject = paramArray[0];
        Class<?> inputClass = paramTypeArray[0];
        if (null == inputObject) {
            inputObject = inputClass.getDeclaredConstructor().newInstance();
        }
        GatewayEntity gatewayEntity = this.giveGatewayEntity();
        BeanCopier beanCopier = BeanCopier.create(GatewayEntity.class, GatewayEntity.class, false);
        beanCopier.copy(gatewayEntity, inputObject, null);

        paramArray[0] = inputObject;
        Object result = pjp.proceed(paramArray);
        log.info("[response] = {}", JSON.toJSONString(result));
        return result;
    }

    /**
     * 获取gateway请求信息
     *
     * @return
     */
    private GatewayEntity giveGatewayEntity() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (null == requestAttributes) {
            log.error("[giveGatewayEntity error, requestAttributes is null]");
            return new GatewayEntity();
        }
        HttpServletRequest request = requestAttributes.getRequest();
        String loginInfo = request.getHeader(GatewayConstant.LOGIN_INFO);
        GatewayEntity gatewayEntity = JSON.parseObject(loginInfo, GatewayEntity.class);
        if (null == gatewayEntity) {
            log.error("[giveGatewayEntity error, gatewayEntity is null]");
            return new GatewayEntity();
        }
        return gatewayEntity;
    }

}
