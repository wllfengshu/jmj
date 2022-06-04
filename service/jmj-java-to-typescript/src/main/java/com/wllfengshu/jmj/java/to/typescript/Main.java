package com.wllfengshu.jmj.java.to.typescript;

import com.wllfengshu.jmj.java.to.typescript.work.JavaToTypeScript;

/**
 * 入口
 *
 * @author wangll
 * @date 2022-06-01 8:59
 */
public class Main {

    private static final String COCOS_BASE_PATH = "E:\\005java\\001game\\maJiang\\jmj\\client\\assets\\scripts\\server\\";
    private static final String JMJ_API_PACKAGE = "com.wllfengshu.jmj.provider.api.";

    public static void main(String[] args) {
        // 1生成公共类
        JavaToTypeScript.run("com.wllfengshu.jmj.common.entity.gateway", COCOS_BASE_PATH + "gateway\\");
        // 2生成实体类(包含接口)
        run("dice");
        run("hall");
        run("majiang");
        run("player");
        run("room");
    }

    private static void run(String modularName) {
        JavaToTypeScript.run(JMJ_API_PACKAGE + modularName, COCOS_BASE_PATH + modularName);
    }
}
