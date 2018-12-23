package com.windmobi.tools;

import com.alibaba.fastjson.JSON;

public class FastjsonTools {
    private static final String TAG = FastjsonTools.class.getSimpleName();

    static FastjsonTools sInstance;

    public FastjsonTools() {}

    public static FastjsonTools getInstance() {
        if (sInstance == null) {
            sInstance = new FastjsonTools();
        }
        return sInstance;
    }

    public <T> T getAppInfo(String jsonString, Class<T> cls) {
        T t = null;
        try {
            t = JSON.parseObject(jsonString, cls);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }
}
