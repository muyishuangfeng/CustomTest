package com.yk.custom.activity;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.yk.custom.R;
import com.yk.custom.utils.ToastUtils;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    //登录、注册
    public Button mBtnLogin, mBtnRegister;
    //用户名、密码
    public EditText mEdtName, mEdtPass;
    public TextInputLayout mTxtName, mTxtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    /**
     * 初始化控件
     */
    public void initView() {
        mEdtName = (EditText) findViewById(R.id.edt_user);
        mEdtName.addTextChangedListener(new MyTextWatch(mEdtName));
        mEdtPass = (EditText) findViewById(R.id.edt_pass);
        mEdtPass.addTextChangedListener(new MyTextWatch(mEdtPass));

        mTxtName = (TextInputLayout) findViewById(R.id.txt_user);
        mTxtPass = (TextInputLayout) findViewById(R.id.txt_pass);

        mBtnLogin = (Button) findViewById(R.id.btn_login);
        mBtnLogin.setOnClickListener(this);

        mBtnRegister=(Button)findViewById(R.id.btn_register);
        mBtnRegister.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login: {//登录
                canLogin();
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);

            }
            break;
            case R.id.btn_register:{//注册
                Intent intent = new Intent(this,RegisterActivity.class);
                startActivity(intent);

            }
        }
    }

    /**
     * 内容改变监听器
     */
    public class MyTextWatch implements TextWatcher {
        private View view;

        public MyTextWatch(View view) {
            this.view = view;

        }

        /**
         * 输入内容改变时调用
         *
         * @param charSequence
         * @param i
         * @param i1
         * @param i2
         */
        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        /**
         * 输入内容改变前调用
         *
         * @param charSequence
         * @param i
         * @param i1
         * @param i2
         */
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        /**
         * 输入内容改变后调用
         *
         * @param editable
         */
        @Override
        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.edt_user: {
                    isNameAviable();
                }
                break;
                case R.id.edt_pass: {
                    isPassAviable();
                }
                break;
            }

        }
    }

    /**
     * 是否可以登录
     */
    public void canLogin() {
        if (!isNameAviable()) {
            ToastUtils.showToast(this, getResources().getString(R.string.check));
            return;
        }
        if (!isPassAviable()) {
            ToastUtils.showToast(this, getResources().getString(R.string.check));
            return;
        }
        ToastUtils.showToast(this, getResources().getString(R.string.login_success));

    }

    /**
     * 用户名是否可用
     *
     * @return
     */
    public boolean isNameAviable() {
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
    public boolean isPassAviable() {
        if (mEdtPass.getText().toString().trim().equals("")
                || mEdtName.getText().toString().trim().isEmpty()) {
            mTxtPass.setError(getResources().getString(R.string.error_pass));
            mEdtPass.requestFocus();
            return false;
        }
        mTxtPass.setErrorEnabled(false);
        return true;
    }
}
