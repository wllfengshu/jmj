package com.wllfengshu.jmj.common.util;

import java.util.UUID;

/**
 * @author wangll
 * @date 2022-05-08 0:07
 */
public class CustomStringUtils {

    /**
     * 获取UUID
     *
     * @return
     */
    public static String giveUuid() {
        return UUID.randomUUID().toString();
    }

}
