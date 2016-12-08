package com.yk.custom.base;

import android.app.Application;
import android.icu.util.TimeUnit;

import com.orhanobut.logger.Logger;
import com.zhy.http.okhttp.OkHttpUtils;

import okhttp3.OkHttpClient;

/**
 * Created by Silence on 2016/12/7.
 */

public class MyApplication extends Application {

    public static  String TAG="CustomLogger";
    @Override
    public void onCreate() {
        super.onCreate();

        OkHttpClient okHttpClient= new OkHttpClient.Builder().
                connectTimeout(10000L, java.util.concurrent.TimeUnit.MILLISECONDS).
                readTimeout(10000L, java.util.concurrent.TimeUnit.MILLISECONDS).
                build();
        OkHttpUtils.initClient(okHttpClient);
        Logger.init(TAG);
    }
}
