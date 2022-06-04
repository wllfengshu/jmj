package com.wllfengshu.jmj.java.to.typescript.work;

import com.wllfengshu.jmj.java.to.typescript.util.ClassFileUtil;
import com.wllfengshu.jmj.java.to.typescript.assembly.TypeScriptUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * @author wangll
 * @date 2022-06-04 18:15
 */
@Slf4j
public class JavaToTypeScript {

    private static final ClassLoader CLASS_LOADER = JavaToTypeScript.class.getClassLoader();
    private static final String TYPE_SCRIPT_SUFFIX = ".ts";
    private static final String SPOT = "\\.";
    private JavaToTypeScript() {}

    /**
     * run
     *
     * @param packageName 待生成的包路径
     * @param outputPath 输出路径
     */
    public static void run(String packageName, String outputPath) {
        // 1读取包路径
        URL url = CLASS_LOADER.getResource(packageName.replaceAll(SPOT, "/"));
        assert url != null;
        // 2获取所有class
        List<Class<?>> allClass = ClassFileUtil.getAllClass(new File(url.getPath()));
        // 3转换类型
        List<String> allTypeScript = TypeScriptUtil.getAllTypeScript(allClass);
        log.info(String.valueOf(allTypeScript));
        // 4output
        assert allClass.size() == allTypeScript.size();
        for (int i = 0; i < allClass.size(); i++) {
            output(outputPath, allClass.get(i), allTypeScript.get(i));
        }
    }

    /**
     * 写文件
     *
     * @param outputPath
     * @param clazz
     * @param typeScript
     */
    private static void output(String outputPath, Class<?> clazz, String typeScript) {
        try {
            if (clazz.isInterface()) {
                // 如果是接口往上一级目录生成
                outputPath = outputPath.substring(NumberUtils.INTEGER_ZERO, outputPath.lastIndexOf("\\"));
            }
            String path = outputPath + File.separator + clazz.getSimpleName() + TYPE_SCRIPT_SUFFIX;
            FileUtils.write(new File(path), typeScript, Charsets.UTF_8);
        } catch (IOException e) {
            log.error("writeFile error", e);
        }
    }
}

