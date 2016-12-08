package com.yk.custom.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import com.githang.statusbar.StatusBarCompat;
import com.yk.custom.R;
import com.yk.custom.base.BaseActivity;
import com.yk.custom.utils.SharedPreferencesUtil;

/**
 * Created by Silence on 2016/12/6.
 */

public class SplashActivity extends AppCompatActivity {
    //是否是第一次进入
    boolean isFirstIn = false;
    private static final int GO_HOME = 1000;
    private static final int GO_GUIDE = 1001;
    // 延迟3秒
    private static final long SPLASH_DELAY_MILLIS = 3000;
    private SharedPreferencesUtil mPreferencesUtil;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarCompat.setStatusBarColor(this, getResources().getColor(R.color.colorPrimary),true);
        setContentView(R.layout.activity_splash);
        init();
    }

    /**
     * 初始化
     */
    private void init() {
        mPreferencesUtil = new SharedPreferencesUtil(getApplicationContext());
        // 判断程序与第几次运行，如果是第一次运行则跳转到引导界面，否则跳转到主界面
        if (!mPreferencesUtil.getIsFirst().equals("1")) {
            // 使用Handler的postDelayed方法，3秒后执行跳转到MainActivity
            mHandler.sendEmptyMessageDelayed(GO_HOME, SPLASH_DELAY_MILLIS);
        } else {
            mHandler.sendEmptyMessageDelayed(GO_GUIDE, SPLASH_DELAY_MILLIS);
        }

    }

    /**
     * 进入主页面
     */
    private void goHome() {
        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
        SplashActivity.this.startActivity(intent);
        SplashActivity.this.finish();
    }

    /**
     * 进入引导页面
     */
    private void goGuide() {
        Intent intent = new Intent(SplashActivity.this, GuideActivity.class);
        SplashActivity.this.startActivity(intent);
        SplashActivity.this.finish();
    }
    /**
     * Handler:跳转到不同界面
     */
    private final Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case GO_HOME://进入主页面
                    goHome();
                    break;
                case GO_GUIDE://进入引导页
                    goGuide();
                    break;
            }
            super.handleMessage(msg);
        }
    };

}
