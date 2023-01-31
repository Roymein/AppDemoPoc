package com.dev.service.model;

import com.dev.service.model.entries.User;
import com.dev.service.presenter.OnLoginFinishedListener;

public interface LoginModel {

    void login(User user, OnLoginFinishedListener listener);
}
