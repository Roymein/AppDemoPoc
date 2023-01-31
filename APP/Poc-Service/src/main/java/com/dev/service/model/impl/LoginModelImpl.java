package com.dev.service.model.impl;

import android.os.Handler;
import android.text.TextUtils;

import com.dev.service.model.LoginModel;
import com.dev.service.model.entries.User;
import com.dev.service.presenter.OnLoginFinishedListener;

public class LoginModelImpl implements LoginModel {

    @Override
    public void login(User user, OnLoginFinishedListener listener) {
        String userName = user.getUserName();
        String passWord = user.getPassWord();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean error = false;
                if (TextUtils.isEmpty(userName)) {
                    listener.onUsernameError();// model层里面回调 listener
                    error = true;
                }
                if (TextUtils.isEmpty(passWord)) {
                    listener.onPasswordError();
                    error = true;
                }
                if (!error) {
                    listener.onSuccess();
                }
            }
        }, 2000);
    }
}
