package com.wllfengshu.jmj.java.to.typescript.assembly;

import io.swagger.annotations.ApiModelProperty;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 转换实体类
 *
 * @author wangll
 * @date 2022-06-04 18:28
 */
@Slf4j
public class TypeScriptUtil {

    private static final String CLASS_TEMPLATE = "interface %s {\n%s\n}\n";
    private static final String CLASS_TEMPLATE_EXTENDS = "interface %s extends %s {\n%s\n}\n";
    private static final String CLASS_FIELD_TEMPLATE = "     // %s\n     %s?: %s;";
    private static final String SERIAL_VERSION_UID = "serialVersionUID";
    private static final Map<String, String> TYPE_MAP = new HashMap<>();
    private TypeScriptUtil() {}
    static {
        TYPE_MAP.put("byte", "string");
        TYPE_MAP.put("Byte", "string");
        TYPE_MAP.put("short", "number");
        TYPE_MAP.put("Short", "number");
        TYPE_MAP.put("int", "number");
        TYPE_MAP.put("Integer", "number");
        TYPE_MAP.put("long", "number");
        TYPE_MAP.put("Long", "number");
        TYPE_MAP.put("float", "number");
        TYPE_MAP.put("Float", "number");
        TYPE_MAP.put("double", "number");
        TYPE_MAP.put("Double", "number");
        TYPE_MAP.put("char", "string");
        TYPE_MAP.put("Character", "string");

        TYPE_MAP.put("String", "string");
        TYPE_MAP.put("Date", "string");
        TYPE_MAP.put("DateTime", "string");
        TYPE_MAP.put("BigDecimal", "number");
        TYPE_MAP.put("BigInteger", "number");
        TYPE_MAP.put("List", "[]");
        TYPE_MAP.put("Map", "{}");
    }

    public static List<String> getAllTypeScript(List<Class<?>> classes) {
        return classes.stream()
                .map(c -> {
                    if (c.isEnum()) {
                        return TypeScriptEnum.getTypeScriptForEnum(c);
                    }else if (c.isInterface()) {
                        return TypeScriptService.getTypeScriptForService(c);
                    }
                    return getTypeScript(c);
                })
                .collect(Collectors.toList());
    }

    /**
     * 转换类型
     *
     * @param clazz
     * @return
     */
    private static String getTypeScript(Class<?> clazz) {
        Class<?> superclass = clazz.getSuperclass();

        Field[] declaredFields = clazz.getDeclaredFields();
        String typeBody = Arrays.stream(declaredFields)
                .filter(f -> !SERIAL_VERSION_UID.equals(f.getName()))
                .map(field -> String.format(CLASS_FIELD_TEMPLATE,
                                getFieldRemark(field),
                                field.getName(),
                                TYPE_MAP.getOrDefault(field.getType().getSimpleName(), field.getType().getSimpleName())))
                .collect(Collectors.joining(StringUtils.LF));

        if (Object.class.equals(superclass)) {
            return String.format(CLASS_TEMPLATE, clazz.getSimpleName(), typeBody);
        }
        return String.format(CLASS_TEMPLATE_EXTENDS, clazz.getSimpleName(), superclass.getSimpleName(), typeBody);
    }

    /**
     * 获取字段注释
     *
     * @param field
     * @return
     */
    private static String getFieldRemark(Field field) {
        try {
            ApiModelProperty annotation = field.getAnnotation(ApiModelProperty.class);
            if (Objects.nonNull(annotation)){
                return annotation.value();
            }
        } catch (Exception e) {
            log.error("getFieldRemark is null", e);
        }
        return StringUtils.EMPTY;
    }
}
