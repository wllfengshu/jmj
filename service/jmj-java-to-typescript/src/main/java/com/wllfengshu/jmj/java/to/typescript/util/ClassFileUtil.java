package com.wllfengshu.jmj.java.to.typescript.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author wangll
 * @date 2022-06-04 18:15
 */
@Slf4j
public class ClassFileUtil {

    private static final String CLASS_STR = "class";
    private static final String CLASS_SUFFIX = FilenameUtils.EXTENSION_SEPARATOR_STR + CLASS_STR;
    private static final String TARGET_CLASS_PATH = "target\\classes\\";
    private ClassFileUtil() {}

    /**
     * 获取目录下所有class文件
     *
     * @param file
     * @return
     */
    public static List<Class<?>> getAllClass(File file) {
        if (!file.isDirectory()) {
            log.warn("File is null");
            return new ArrayList<>();
        }
        // 1获取目录下所有.class文件路径
        List<String> classFilePath = FileUtils.listFiles(file, null, true).stream()
                .map(File::getAbsolutePath)
                .filter(s -> StringUtils.endsWith(s, CLASS_SUFFIX))
                .collect(Collectors.toList());

        // 2获取class的包名
        List<String> className = classFilePath.stream()
                .map(filePath -> StringUtils.substringBetween(filePath, TARGET_CLASS_PATH, CLASS_SUFFIX)
                        .replaceAll(File.separator + File.separator, FilenameUtils.EXTENSION_SEPARATOR_STR))
                .collect(Collectors.toList());

        // 3获取class文件，并加载到内存
        return ClassUtils.convertClassNamesToClasses(className)
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
