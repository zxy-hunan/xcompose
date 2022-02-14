package com.mltec.module.login.ui.activity;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.mltec.lib.utils.ImmUtils;
import com.mltec.lib.utils.MLog;
import com.mltec.lib.utils.MStringUtils;
import com.mltec.lib.utils.ToastUtils;
import com.mltec.lib_common.ui.BaseActivity;
import com.mltec.module.login.R;
import com.mltec.module.login.databinding.ActivityLoginBinding;
import com.mltec.module.login.moudel.LoginViewModule;


import dagger.hilt.android.AndroidEntryPoint;

@Route(path = "/login/LoginActivity")
@AndroidEntryPoint
public class LoginActivity extends BaseActivity<ActivityLoginBinding,LoginViewModule> {
//    LoginViewModule vm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        vm = new ViewModelProvider(this).get(LoginViewModule.class);
    }

    @Override
    protected void initData() {
        vm.getLogingName().observe(this, s -> binding.loginEtInputAccount.setText(s));
        vm.getLogingPassword().observe(this, s -> binding.loginEtInputPassword.setText(s));
    }
    @Override
    protected void initView() {
        binding.loginBtnAccountRegistered.setOnClickListener(v -> {

        });
        binding.loginBtnAccountLogin.setOnClickListener(v -> {
            MLog.e("loginBtnAccountLogin.onClick");
            String account = binding.loginEtInputAccount.getText().toString();
            String passsword = binding.loginEtInputPassword.getText().toString();
            if (isValidation(account, passsword, true)) {

            }

        });
        ImmUtils.setCloseKeyboard(binding.loginBtnAccountLogin,this);
        ImmUtils.setCloseKeyboard(binding.loginBtnAccountRegistered,this);
    }

    //2021/11/8 功能：输入效验
    private boolean isValidation(String account, String password, boolean isLogin) {
        if (MStringUtils.isNullOrEmpty(account)) {
            ToastUtils.showMessage(
                    isLogin ? R.string.login_account_limit : R.string.login_input_account_number_non);

            return false;
        }
        if (isLogin) {
            if (account.length() < 4) {
                ToastUtils.showMessage(R.string.login_account_limit);
                return false;
            }
        } else {
            if (account.length() < 4 || account.length() > 20) {
                ToastUtils.showMessage(R.string.login_account_limit);
                return false;
            }
        }
        if (MStringUtils.isNullOrEmpty(password)) {
            ToastUtils.showMessage(R.string.login_password_limit);
            return false;
        }
        if (password.length() < 6 || password.length() > 20) {
            ToastUtils.showMessage(R.string.login_password_limit);
            return false;
        }
        return true;
    }

}