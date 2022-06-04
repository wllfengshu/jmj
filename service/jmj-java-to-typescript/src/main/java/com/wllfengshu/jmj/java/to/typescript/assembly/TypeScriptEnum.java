package com.wllfengshu.jmj.java.to.typescript.assembly;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 转换枚举
 *
 * @author wangll
 * @date 2022-06-04 18:28
 */
@Slf4j
public class TypeScriptEnum {

    private static final String ENUM_TEMPLATE = "enum %s {\n%s\n}\n";
    private static final String ENUM_FIELD_TEMPLATE = "     %s";
    private static final String VALUES = "$VALUES";
    private TypeScriptEnum() {}

    public static String getTypeScriptForEnum(Class<?> clazz) {
        Field[] declaredFields = clazz.getDeclaredFields();
        String typeBody = Arrays.stream(declaredFields)
                .filter(f -> !VALUES.equals(f.getName()))
                .map(field -> String.format(ENUM_FIELD_TEMPLATE, field.getName()))
                .collect(Collectors.joining(",\n"));

        return String.format(ENUM_TEMPLATE, clazz.getSimpleName(), typeBody);
    }
}
