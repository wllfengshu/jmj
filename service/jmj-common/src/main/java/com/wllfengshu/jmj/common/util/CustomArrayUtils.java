package com.wllfengshu.jmj.common.util;

/**
 * @author wangll
 * @date 2022-05-09 21:18
 */
public class CustomArrayUtils {

    /**
     * 求和
     *
     * @param num
     * @return
     */
    public static int sum(int[] num) {
        int total = 0;
        for (int n : num) {
            total += n;
        }
        return total;
    }
}
