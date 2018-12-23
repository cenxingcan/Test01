package com.windmobi.framework;

import android.util.Log;

public class MLog {
    private static final String LOG_TAG = "AppUpGrade";

    public static void d(String className, String msg) {
        Log.d(LOG_TAG, "[" + className + "]" + " " + msg);
    }
}
