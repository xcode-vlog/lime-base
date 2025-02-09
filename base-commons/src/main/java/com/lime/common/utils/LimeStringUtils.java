package com.lime.common.utils;

public class LimeStringUtils {
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static String emptyToDefault(String str, String defaultStr) {
        return isEmpty(str) ? defaultStr : str;
    }
}
