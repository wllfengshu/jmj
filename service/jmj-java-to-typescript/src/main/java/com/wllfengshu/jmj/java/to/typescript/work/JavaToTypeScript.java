package com.wllfengshu.jmj.java.to.typescript.work;

import com.wllfengshu.jmj.java.to.typescript.assembly.TypeScriptEntity;
import com.wllfengshu.jmj.java.to.typescript.assembly.TypeScriptEnum;
import com.wllfengshu.jmj.java.to.typescript.assembly.TypeScriptService;
import com.wllfengshu.jmj.java.to.typescript.util.ClassFileUtil;
import com.wllfengshu.jmj.java.to.typescript.util.OutputFileUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wangll
 * @date 2022-06-04 18:15
 */
@Slf4j
public class JavaToTypeScript {

    private static final ClassLoader CLASS_LOADER = JavaToTypeScript.class.getClassLoader();
    private static final String SPOT = "\\.";
    private static final String SLASH = "/";
    private JavaToTypeScript() {}

    /**
     * run
     *
     * @param packageName 待生成的包路径
     * @param outputPath 输出路径
     */
    public static void run(String packageName, String outputPath) {
        // 1读取包路径
        URL url = CLASS_LOADER.getResource(packageName.replaceAll(SPOT, SLASH));
        assert url != null;
        // 2获取所有class
        List<Class<?>> allClass = ClassFileUtil.getAllClass(new File(url.getPath()));
        // 3转换类型
        List<String> allTypeScript = getAllTypeScript(allClass);
        log.info(String.valueOf(allTypeScript));
        // 4output
        assert allClass.size() == allTypeScript.size();
        for (int i = 0; i < allClass.size(); i++) {
            OutputFileUtil.output(outputPath, allClass.get(i), allTypeScript.get(i));
        }
    }

    /**
     * 获取所有ts脚本
     *
     * @param classes
     * @return
     */
    public static List<String> getAllTypeScript(List<Class<?>> classes) {
        return classes.stream()
                .map(c -> {
                    if (c.isEnum()) {
                        return TypeScriptEnum.getTypeScriptForEnum(c);
                    }else if (c.isInterface()) {
                        return TypeScriptService.getTypeScriptForService(c);
                    }
                    return TypeScriptEntity.getTypeScript(c);
                })
                .collect(Collectors.toList());
    }
}

