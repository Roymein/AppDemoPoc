package com.dev.service.presenter.impl

import com.dev.service.model.LoginModel
import com.dev.service.model.entries.User
import com.dev.service.model.impl.LoginModelImpl
import com.dev.service.presenter.LoginPresenter
import com.dev.service.presenter.OnLoginFinishedListener
import com.dev.service.view.LoginView

class LoginPresenterImpl(private var loginView: LoginView? = null) : LoginPresenter,
    OnLoginFinishedListener {

    private val loginModel: LoginModel = LoginModelImpl()

    override fun validateCredentials(user: User?) {
        loginView?.showProgress()
        loginModel.login(user, this)
    }

    override fun onDestroy() {
        loginView = null
    }

    override fun onUsernameError() {
        loginView?.setUsernameError();
        loginView?.hideProgress();
    }

    override fun onPasswordError() {
        loginView?.setPasswordError();
        loginView?.hideProgress();
    }

    override fun onSuccess() {
        loginView?.showSuccess()
    }
}