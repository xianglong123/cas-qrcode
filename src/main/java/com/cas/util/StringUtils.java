package com.cas.util;

/**
 * @author xiang_long
 * @version 1.0
 * @date 2023/1/30 3:31 下午
 * @desc
 */
public class StringUtils {

    public static boolean isBlank(String val) {
        return val == null || "".equals(val);
    }

}
