package com.windmobi.test01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.windmobi.entity.AppInfo;
import com.windmobi.framework.MLog;
import com.windmobi.tools.AppUpdateUtils;
import com.windmobi.tools.FastjsonTools;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = MainActivity.class.getSimpleName();

    private TextView mTextView;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        mTextView = (TextView) findViewById(R.id.textView);
        mButton = (Button) findViewById(R.id.buttonView);

        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        MLog.d(TAG, "onClick " + view);
        if (view == mButton) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //MLog.d(TAG, "onClick --> " + AppUpdateUtils.getInstance(MainActivity.this).getJsonString());
                    AppUpdateUtils.getInstance(MainActivity.this).getJsonString(new AppUpdateUtils.HttpCallbackListener() {
                        @Override
                        public void onFinish(String response) {
                            MLog.d(TAG, "onFinish -> response = " + response);
                            /*Gson gson = new Gson();
                            List<AppInfo> appInfos = gson.fromJson(response, new TypeToken<List<AppInfo>>() {}.getType());//gson.fromJson(response, AppInfo.class);
                            if (appInfos != null && appInfos.size() > 0) {
                                for (AppInfo appInfo : appInfos) {
                                    MLog.d(TAG, "onFinish -> appInfo = " + appInfo);
                                    if (appInfo != null) {
                                        MLog.d(TAG, "onFinish -> appInfo.toString() = " + appInfo.toString());
                                    }
                                }
                            }*/
                            List<AppInfo> appInfos = JSON.parseArray(response, AppInfo.class);
                            MLog.d(TAG, "onFinish -> appInfos = " + appInfos);
                        }

                        @Override
                        public void onError(Exception e) {
                            MLog.d(TAG, "onError -> Exception = " + e.toString());
                        }
                    });
                }
            }).start();

        }
    }
}
