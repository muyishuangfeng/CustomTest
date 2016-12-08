package com.yk.custom.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.TextView;

import com.yk.custom.R;
import com.yk.custom.base.BaseActivity;



/**
 * Created by Silence on 2016/12/8.
 */

public class AboutActivity extends BaseActivity  {
    Toolbar mToolBar;
    TextView mTxtLinkGitHub;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        initView();
        initData();

    }

    /**
     * 初始化界面
     */
    public void initView() {
        mToolBar = (Toolbar) findViewById(R.id.toolbar);
        mToolBar.setTitle(R.string.about_us);
        mToolBar.setTitleTextColor(getResources().getColor(R.color.white));
        mToolBar.setNavigationIcon(R.mipmap.back);
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    /**
     * 初始化数据
     */
    public void initData(){
        mTxtLinkGitHub = (TextView) findViewById(R.id.txt_github_link);
        String url = "https://github.com/muyishuangfeng";
        SpannableString text = new SpannableString(url);
        NoUnderLineSpan noUnderLineSpan = new NoUnderLineSpan(AboutActivity.this,
                url);
        text.setSpan(noUnderLineSpan, 0, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTxtLinkGitHub.setText(text);
        mTxtLinkGitHub.setMovementMethod(LinkMovementMethod.getInstance());

    }

    /**
     *
     */
    @SuppressLint("ParcelCreator")
    public static class NoUnderLineSpan extends URLSpan {
        public Context mContext;
        public String url;

        public NoUnderLineSpan(Context context,String str){
            super(str);
            this.mContext=context;
            this.url=str;

        }

        @Override
        public void updateDrawState(TextPaint ds) {
            super.updateDrawState(ds);
            ds.setUnderlineText(false);
            ds.setColor(Color.parseColor("#00B2EE"));
        }

        @Override
        public void onClick(View widget) {
            Intent intent= new Intent(mContext,WebActivity.class);
            intent.putExtra(WebActivity.WEB_URL,url);
            mContext.startActivity(intent);
        }
    }
}
