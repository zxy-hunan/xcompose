package com.mltec.lib.utils;

import android.util.Log;

public class MLog {
    public static final String TAG_START = "-SCC-";// Tag头，用于在cmd命令行里过滤用 eg:adb logcat -s qn
    private MLog() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static void e(Class<?> cla, String msg) {
        e(cla.getSimpleName(), msg);
    }

    public static void e(String msg) {
        Log.e(TAG_START, msg + "");
    }
    public static void e(String tag, String msg) {
        Log.e(TAG_START + tag, msg + "");
    }

    public static void i(String msg) {
        Log.i(TAG_START, msg + "");
    }

    public static void i(String tag, String msg) {
        Log.i(TAG_START + tag, msg + "");
    }
    public static void d(String msg) {
        Log.d(TAG_START, msg + "");
    }

    public static void d(String tag, String msg) {
        Log.d(TAG_START + tag, msg + "");
    }

}
