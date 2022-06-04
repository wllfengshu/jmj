package com.wllfengshu.jmj.java.to.typescript.assembly;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.openfeign.FeignClient;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 转换service
 *
 * @author wangll
 * @date 2022-06-04 18:28
 */
@Slf4j
public class TypeScriptService {

    private static final String IMPORT_BASE_SERVICE = "import BaseService from \"./BaseService\";\n\n";
    private static final String SERVICE_TEMPLATE = "export default class %s extends BaseService {\n%s\n}\n\n";

    private static final String SERVICE_NAME_TEMPLATE = "     private static readonly serverName : string = \"%s\";\n";
    private static final String SERVICE_INSTANCE_TEMPLATE = "     public static readonly instance : %s = new %s();\n\n";

    private static final String METHOD_DEFINE = "     // %s\n     public %s(request : %s) : %s {\n%s\n     }\n";
    private static final String METHOD_RETURN = "          return <%s> JSON.parse(super.callInterface(%s.serverName, \"%s\", request));";

    public static String getTypeScriptForService(Class<?> clazz) {
        String className = clazz.getSimpleName();

        return IMPORT_BASE_SERVICE
                + String.format(SERVICE_TEMPLATE, className, getBody(clazz, className));
    }

    /**
     * 获取内容
     *
     * @param clazz
     * @param className
     * @return
     */
    private static String getBody(Class<?> clazz, String className) {
        // 获取@FeignClient注解对应的name属性
        FeignClient annotation = clazz.getAnnotation(FeignClient.class);
        String name = annotation.name();

        return String.format(SERVICE_NAME_TEMPLATE, name)
                + String.format(SERVICE_INSTANCE_TEMPLATE, className, className)
                + getMethod(clazz, className);
    }

    /**
     * 获取方法
     *
     * @param clazz
     * @param className
     * @return
     */
    private static String getMethod(Class<?> clazz, String className) {
        Method[] declaredMethods = clazz.getDeclaredMethods();
        return Arrays.stream(declaredMethods)
                .map(method -> {
                    String methodName = method.getName();
                    String requestTypeName = method.getParameters()[0].getType().getSimpleName();
                    String responseTypeName = method.getReturnType().getSimpleName();

                    String methodReturn = String.format(METHOD_RETURN, responseTypeName, className, methodName);
                    return String.format(METHOD_DEFINE, getMethodRemark(method), methodName, requestTypeName, responseTypeName, methodReturn);
                })
                .collect(Collectors.joining(StringUtils.LF));
    }

    /**
     * 获取方法注释
     *
     * @param method
     * @return
     */
    private static String getMethodRemark(Method method) {
        try {
            ApiOperation annotation = method.getAnnotation(ApiOperation.class);
            if (Objects.nonNull(annotation)){
                return annotation.value();
            }
        } catch (Exception e) {
            log.error("getMethodRemark is null", e);
        }
        return StringUtils.EMPTY;
    }
}
