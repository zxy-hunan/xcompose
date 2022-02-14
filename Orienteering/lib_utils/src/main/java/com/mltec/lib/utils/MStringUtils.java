package com.mltec.lib.utils;

public class MStringUtils {
    private MStringUtils() {
    }

    public static boolean isNullOrEmpty(String str) {
        if (str == null) return true;
        if (str.equals("null")) return true;
        if (str.equals("[null]")) return true;
        if (str.isEmpty()) return true;
        if (str.equals("")) return true;
        return str.equals("(null)");
    }
    public static boolean isNullOrEmpty(Object str) {
        if (str == null) return true;
        if (str.equals("null")) return true;
        if (str.equals("[null]")) return true;
        if (str.equals("")) return true;
        return str.equals("(null)");
    }
    //2018/5/10 功能描述：
    public static String replace(String str, String old, String newStr) {
        if(!MStringUtils.isNullOrEmpty(str))
        {
            return str.replace(old,newStr);
        }
        return "";
    }
}
