package com.dev.service.ui

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dev.service.R
import com.dev.service.model.entries.User
import com.dev.service.presenter.LoginPresenter
import com.dev.service.presenter.impl.LoginPresenterImpl
import com.dev.service.view.LoginView


class LoginActivity : AppCompatActivity(), LoginView, View.OnClickListener {
    private var progressBar: ProgressBar? = null
    private var username: EditText? = null
    private var password: EditText? = null
    private var presenter: LoginPresenter? = null
    private var button: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        progressBar = findViewById(R.id.progress)
        username = findViewById(R.id.username)
        password = findViewById(R.id.password)
        button = findViewById(R.id.button)

        button!!.setOnClickListener(this)
        //创建一个presenter对象，当点击登录按钮时，让presenter去调用model层的login()方法，验证帐号密码
        presenter = LoginPresenterImpl(this);
    }

    override fun onDestroy() {
        presenter!!.onDestroy()
        super.onDestroy()
    }

    override fun showProgress() {
        progressBar!!.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar!!.visibility = View.GONE
    }

    override fun setUsernameError() {
        username!!.error = getString(R.string.username_error);
    }

    override fun setPasswordError() {
        password!!.error = getString(R.string.password_error)
    }

    override fun showSuccess() {
        progressBar!!.visibility = View.GONE
        Toast.makeText(this, "login success", Toast.LENGTH_SHORT).show();
    }

    override fun onClick(v: View?) {
        val user = User(username!!.text.toString(), password!!.text.toString())
        presenter!!.validateCredentials(user)
    }
}