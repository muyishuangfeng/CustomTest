package com.yk.custom.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import  com.orhanobut.logger.Logger;
import com.yk.custom.R;
import com.yk.custom.base.BaseActivity;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Silence on 2016/12/6.
 */

public class MainActivity extends BaseActivity implements View.OnClickListener {

    public Toolbar mToolBar;
    //侧滑按钮
    public DrawerLayout mDrawer;
    public ActionBarDrawerToggle mActionDrawer;
    //关于我们、设置、夜间模式、我的茶秀、反馈、收藏、分享
    public LinearLayout mLytAbout, mLytSetting, mLytDark, mLytMyMessage,
            mLytFeedback, mLytCollection, mLytShare;
    //圆形头像
    public CircleImageView mImgMyself;
    //用户名
    public TextView mTxtUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Logger.d("MainActivity创建了 onCreate");
        initView();
    }

    /**
     * 初始化控件
     */
    public void initView() {
        mLytAbout = (LinearLayout) findViewById(R.id.lyt_about);
        mLytAbout.setOnClickListener(this);

        mLytCollection = (LinearLayout) findViewById(R.id.lyt_collection);
        mLytCollection.setOnClickListener(this);

        mLytFeedback = (LinearLayout) findViewById(R.id.lyt_feedback);
        mLytFeedback.setOnClickListener(this);

        mLytMyMessage = (LinearLayout) findViewById(R.id.lyt_mymessage);
        mLytMyMessage.setOnClickListener(this);

        mLytSetting = (LinearLayout) findViewById(R.id.lyt_setting);
        mLytSetting.setOnClickListener(this);

        mLytShare = (LinearLayout) findViewById(R.id.lyt_share);
        mLytShare.setOnClickListener(this);

        mImgMyself = (CircleImageView) findViewById(R.id.img_user);
        mImgMyself.setOnClickListener(this);

        mTxtUserName = (TextView) findViewById(R.id.txt_username);

        mToolBar = (Toolbar) findViewById(R.id.toolbar);
        mToolBar.setTitle(R.string.home_page);
        mToolBar.setTitleTextColor(getResources().getColor(android.R.color.white));
        mDrawer = (DrawerLayout) findViewById(R.id.drawer);
        mActionDrawer = new ActionBarDrawerToggle(this, mDrawer, mToolBar,
                R.string.open, R.string.close);
        mDrawer.setDrawerListener(mActionDrawer);
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mActionDrawer.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mActionDrawer.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mActionDrawer.onConfigurationChanged(newConfig);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.lyt_about: {//关于我们
                startActivity(new Intent(MainActivity.this, AboutActivity.class));
            }
            break;
            case R.id.lyt_collection: {//收藏

            }
            break;
            case R.id.lyt_feedback: {//反馈

            }
            break;
            case R.id.lyt_mymessage: {//我的茶秀

            }
            break;
            case R.id.lyt_setting: {//设置

            }
            break;
            case R.id.lyt_share: {//分享

            }
            break;
            case R.id.img_user: {//用户

            }
            break;
        }
    }
}
