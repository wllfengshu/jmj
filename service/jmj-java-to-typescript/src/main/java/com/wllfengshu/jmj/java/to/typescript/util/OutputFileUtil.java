package com.wllfengshu.jmj.java.to.typescript.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author wangll
 * @date 2022-06-09 23:44
 */
@Slf4j
public class OutputFileUtil {

    private static final String TYPE_SCRIPT_SUFFIX = ".ts";
    private static final String BACKSLASH = "\\";
    private OutputFileUtil() {}

    /**
     * 写文件
     *
     * @param outputPath
     * @param clazz
     * @param typeScript
     */
    public static void output(String outputPath, Class<?> clazz, String typeScript) {
        try {
            if (clazz.isInterface()) {
                // 如果是接口往上一级目录生成
                outputPath = outputPath.substring(NumberUtils.INTEGER_ZERO, outputPath.lastIndexOf(BACKSLASH));
            }
            String path = outputPath + File.separator + clazz.getSimpleName() + TYPE_SCRIPT_SUFFIX;
            FileUtils.write(new File(path), typeScript, Charsets.UTF_8);
        } catch (IOException e) {
            log.error("writeFile error", e);
        }
    }
}
