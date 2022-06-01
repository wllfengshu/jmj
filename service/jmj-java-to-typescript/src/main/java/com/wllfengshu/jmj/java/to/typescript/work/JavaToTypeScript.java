package com.wllfengshu.jmj.java.to.typescript.work;

import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class JavaToTypeScript {

    //class加载器
    static ClassLoader CLASS_LOADER = JavaToTypeScript.class.getClassLoader();
    //class根路径
    static String BASE_PATH = CLASS_LOADER.getResource("").getPath().substring(1);
    //类型映射
    static Map<String, String> TYPE_MAP = new HashMap<>();

    //super class
    static Class<?> superClass;
    //super class 字段名集合
    static List<String> superClassFieldNameList = new ArrayList<>();

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
        // 把它当作一个普通类
        TYPE_MAP.put("GatewayLoginInfo", "GatewayLoginInfo");
        TYPE_MAP.put("GatewayResponseCodeEnum", "GatewayResponseCodeEnum");
        TYPE_MAP.put("DicePO", "DicePO");

        try {
            //基类
            superClass = CLASS_LOADER.loadClass("com.wllfengshu.jmj.common.entity.gateway.GatewayRequest");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String superClassTypeStr = loadSuperClass();
        String packageName = "com.wllfengshu.jmj.provider.api.dice.model";
        URL url = CLASS_LOADER.getResource(packageName.replaceAll("\\.", "/"));
        //扫描包中的文件
        List<String> allJavaFile = getAllJavaFile(new File(url.getPath()), new ArrayList<>());
        //把包中的class加载到内存中
        List<Class<?>> allClass = getAllClass(allJavaFile);
        //转换类型
        String result = allClass.stream().map(clazz -> getTypeScript(clazz,false)).collect(Collectors.joining("\n"));
        System.out.println(superClassTypeStr);
        System.out.println(result);

        //写入文件
        File file = new File(BASE_PATH + "type.d.ts");
        if(file.exists()){
            file.delete();
        }
//        FileUtil.appendString(superClassTypeStr,file, Charset.defaultCharset());
//        FileUtil.appendString(result,file, Charset.defaultCharset());
    }

    /**
     * 加载父类
     */
    public static String loadSuperClass() {
        try {
            List<String> fieldNameList = FieldUtils
                    .getAllFieldsList(superClass)
                    .stream()
                    .map(Field::getName)
                    .collect(Collectors.toList());
            superClassFieldNameList.addAll(fieldNameList);
            return getTypeScript(superClass, true);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    //转换类型
    public static String getTypeScript(Class<?> clazz, boolean isSupperClass) {
        String template = "interface =className= {\n=typeBody=\n}\n";
        if (Objects.nonNull(superClass) && !isSupperClass) {
            template = "interface =className= extends =superClassName= {\n=typeBody=\n}\n"
                    .replaceAll("=superClassName=", superClass.getSimpleName());
        }
        String typeTemplate = "     // =remark=\n     =fieldName=?: =typeName=;";
        //获取class全部的字段
        String typeBody = FieldUtils
                .getAllFieldsList(clazz)
                .stream()
                //只保留有set get方法的属性
                .filter(field -> {
                    String fieldName = field.getName();
                    String setMethodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                    String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                    try {
                        clazz.getMethod(setMethodName, field.getType());
                        clazz.getMethod(getMethodName);
                        if (isSupperClass) {
                            return true;
                        }
                        //继续判断字段是否存在于父类基类
                        return !superClassFieldNameList.contains(field.getName());
                    } catch (Exception e) {
                        return false;
                    }
                })
                .map(field -> typeTemplate
                        .replaceAll("=fieldName=", field.getName())
                        .replaceAll("=typeName=", TYPE_MAP.get(field.getType().getSimpleName()))
                        .replaceAll("=remark=", getFieldRemark(field))
                )
                .collect(Collectors.joining("\n"));
        return template
                .replaceAll("=className=", clazz.getSimpleName())
                .replaceAll("=typeBody=", typeBody);
    }

    //获取字段注释
    public static String getFieldRemark(Field field) {
        String remark = "";
        try {
            ApiModelProperty apiModelProperty = field.getAnnotation(ApiModelProperty.class);
            if (Objects.nonNull(apiModelProperty)){
                return apiModelProperty.value();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return remark;
    }

    //获取加载的所有class,并且加载到内存
    public static List<Class<?>> getAllClass(List<String> files) {
        return files.stream().map(filePath -> {
            String packageName = StringUtils.substringBetween(filePath, "target\\classes\\", ".class")
                    .replaceAll(File.separator + File.separator, ".");
            try {
                return CLASS_LOADER.loadClass(packageName);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        }).filter(Objects::nonNull).collect(Collectors.toList());
    }

    //加载class文件
    public static List<String> getAllJavaFile(File file, List<String> files) {
        if (!file.isDirectory()) {
            return files;
        }
        file.listFiles(f -> {
            if (f.isDirectory()) {
                getAllJavaFile(f, files);
            } else {
                String name = f.getName();
                if (name.toLowerCase().endsWith(".class")) {
                    files.add(f.getAbsolutePath());
                }
            }
            return false;
        });
        return files;
    }

}

