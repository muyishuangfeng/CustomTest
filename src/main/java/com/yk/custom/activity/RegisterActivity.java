package com.yk.custom.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.githang.statusbar.StatusBarCompat;
import com.yk.custom.R;
import com.yk.custom.base.BaseActivity;
import com.yk.custom.utils.ToastUtils;

/**
 * 注册
 * <p>
 * Created by Silence on 2016/12/6.
 */

public class RegisterActivity extends BaseActivity implements View.OnClickListener {

    public EditText mEdtName, mEdtPass, mEdtConfir, medtEmail;
    //用户名、密码、E-mail、确认密码
    public TextInputLayout mTxtName, mTxtPass, mTxtEmail, mTxtConfirm;
    //注册
    public Button mBtnRegister;
    public Toolbar mToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }

    /**
     * 初始化控件
     */
    public void initView() {
        mToolBar=(Toolbar)findViewById(R.id.toolbar);
        mToolBar.setTitle(R.string.register);
        mToolBar.setNavigationIcon(R.mipmap.back);
        mToolBar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        mToolBar.setTitleTextColor(getResources().getColor(android.R.color.white));


        medtEmail = (EditText) findViewById(R.id.edt_email);
        mEdtPass = (EditText) findViewById(R.id.edt_pass);
        mEdtName = (EditText) findViewById(R.id.edt_user);
        mEdtConfir = (EditText) findViewById(R.id.edt_confirm);

        mTxtName = (TextInputLayout) findViewById(R.id.txt_user);
        mTxtConfirm = (TextInputLayout) findViewById(R.id.txt_confirm);
        mTxtEmail = (TextInputLayout) findViewById(R.id.txt_email);
        mTxtPass = (TextInputLayout) findViewById(R.id.txt_pass);

        mBtnRegister = (Button) findViewById(R.id.btn_register);
        mBtnRegister.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_register: {
                canRegister();
            }
            break;
        }
    }

    /**
     * 是否可以注册
     */
    public void canRegister() {
        if (!isNameAvaliable()) {
            ToastUtils.showToast(this, getResources().getString(R.string.check));
            return;
        }
        if (!isPassAvaliable()) {
            ToastUtils.showToast(this, getResources().getString(R.string.check));
        }
        if (!isConfirAvaliable()) {
            ToastUtils.showToast(this, getResources().getString(R.string.check));
        }
        if (!isEmailAvaliable()) {
            ToastUtils.showToast(this, getResources().getString(R.string.check));
        }
        ToastUtils.showToast(this, getResources().getString(R.string.register_success));


    }

    /**
     * 用户名是否可用
     *
     * @return
     */
    public boolean isNameAvaliable() {
        if (mEdtName.getText().toString().trim().equals("") ||
                mEdtName.getText().toString().trim().isEmpty()) {
            mTxtName.setError(getResources().getString(R.string.error_user));
            mEdtName.requestFocus();
            return false;
        }
        mTxtName.setErrorEnabled(false);
        return true;
    }

    /**
     * 密码是否可用
     *
     * @return
     */
    public boolean isPassAvaliable() {
        if (mEdtPass.getText().toString().trim().equals("") ||
                mEdtPass.getText().toString().trim().isEmpty()) {
            mTxtPass.setError(getResources().getString(R.string.error_pass));
            mEdtPass.requestFocus();
            return false;
        }
        mTxtPass.setErrorEnabled(false);
        return true;
    }

    /**
     * Email是否可用
     *
     * @return
     */
    public boolean isEmailAvaliable() {
        if (medtEmail.getText().toString().trim().equals("") ||
                medtEmail.getText().toString().trim().isEmpty()) {
            mTxtEmail.setError(getResources().getString(R.string.error_email));
            medtEmail.requestFocus();
            return false;
        } else if (!medtEmail.getText().toString().trim().
                matches("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*")) {
            mTxtEmail.setError(getResources().getString(R.string.check_email));
            medtEmail.requestFocus();
            return false;
        }
        mTxtEmail.setErrorEnabled(false);
        return true;
    }

    /**
     * 确认密码是否可用
     *
     * @return
     */
    public boolean isConfirAvaliable() {
        if (mEdtConfir.getText().toString().trim().equals("") ||
                mEdtConfir.getText().toString().trim().isEmpty()) {
            mTxtConfirm.setError(getResources().getString(R.string.error_pass));
            mEdtConfir.requestFocus();
            return false;
        } else if (!mEdtConfir.getText().toString().trim().
                equals(mEdtPass.getText().toString().trim())) {
            mTxtConfirm.setError(getResources().getString(R.string.check_pass));
            mEdtConfir.requestFocus();
            return false;
        }
        mTxtConfirm.setErrorEnabled(false);
        return true;
    }


    /**
     * 内容监听
     */
    public class MyTextWatcher implements TextWatcher {
        private View view;

        public MyTextWatcher(View view) {
            this.view = view;
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.edt_user: {//用户名是否可用
                    isNameAvaliable();
                }
                break;
                case R.id.edt_pass: {//密码是否可用
                    isPassAvaliable();
                }
                break;
                case R.id.edt_email: {//E-mail是否可用
                    isEmailAvaliable();
                }
                break;
                case R.id.edt_confirm: {//确认密码
                    isConfirAvaliable();
                }
                break;
            }

        }

    }
}
