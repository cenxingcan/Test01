package com.windmobi.tools;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;

import com.windmobi.framework.MLog;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class AppUpdateUtils {

    private static final String TAG = AppUpdateUtils.class.getSimpleName();
    private Context mContext;
    private Resources mResources;
    private OkHttpClient mOkHttpClient;

    private static final String testUrl = "http://192.168.2.197:8080/FaceInGuard/output.json";

    static AppUpdateUtils sInstance;

    public AppUpdateUtils(Context context) {
        this.mContext = context;
        this.mResources = context.getResources();
        this.mOkHttpClient = new OkHttpClient();
    }

    public static AppUpdateUtils getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new AppUpdateUtils(context);
        }
        return sInstance;
    }


    public void getJsonString(HttpCallbackListener listener) {
        getJsonString(testUrl, listener);
    }

    private void getJsonString(String url, HttpCallbackListener listener) {
        Request request = new Request.Builder().url(url).build();
        try {
            Response response = mOkHttpClient.newCall(request).execute();
            String callBackStr = null;
            if (response.isSuccessful()) {
                callBackStr = response.body().string();
            }
            //MLog.d(TAG, "response.body().string() = " + response.body().string() + ", response.code() = " + response.code());
            if (TextUtils.isEmpty(callBackStr)) {
                listener.onError(new Exception(Exception.class.getName() + ":" + " Cause of response is null!"));
                return;
            }
            listener.onFinish(callBackStr);
        } catch (IOException e) {
            e.printStackTrace();
            //MLog.d(TAG, "IOException -> " + e.toString());
            listener.onError(e);
        }
    }

    public interface HttpCallbackListener {
        void onFinish(String response);
        void onError(Exception e);
    }
}
