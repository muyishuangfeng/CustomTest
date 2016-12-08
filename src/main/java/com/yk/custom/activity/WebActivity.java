package com.yk.custom.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.githang.statusbar.StatusBarCompat;
import com.yk.custom.R;
import com.yk.custom.utils.ToastUtils;

/**
 * Created by Silence on 2016/12/8.
 */

public class WebActivity extends AppCompatActivity{
    public final static  String WEB_URL="web_url";
    public WebView mWebView;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarCompat.setStatusBarColor(this, getResources().getColor(R.color.colorPrimary),true);
        setContentView(R.layout.activity_web);
        initView();
    }

    /**
     * 初始化控件
     */
    public void initView(){
        ToastUtils.showToast(this,"请稍等...");
        Intent intent = getIntent();
        String url = intent.getStringExtra(WEB_URL);

        mWebView=(WebView)findViewById(R.id.web);
        // 开启浏览器的javascript脚本支持
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.loadUrl(url);

    }
}
