package com.dev.service.presenter;

import com.dev.service.model.entries.User;

public interface LoginPresenter {
    void validateCredentials(User user);

    void onDestroy();
}
