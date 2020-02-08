package io.github.dvegasa.travelhackmoscow.screens.welcome

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import io.github.dvegasa.travelhackmoscow.R
import io.github.dvegasa.travelhackmoscow.helpers.MyApplication
import io.github.dvegasa.travelhackmoscow.helpers.fullscreen
import io.github.dvegasa.travelhackmoscow.helpers.info
import io.github.dvegasa.travelhackmoscow.network.RetrofitGenerator
import io.github.dvegasa.travelhackmoscow.network.requests.AuthRequest
import io.github.dvegasa.travelhackmoscow.screens.main.MainActivity
import io.github.dvegasa.travelhackmoscow.screens.quiz_start.QuizStartActivity
import kotlinx.android.synthetic.main.activity_welcome.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

//        window.apply {
//            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
//            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
//            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//            statusBarColor = Color.TRANSPARENT
//        }

        fullscreen()
        bindViews()
    }

    private fun bindViews() {
        btnRegister.setOnClickListener {
            showCredentials()
            tvAuthState.setText("Регистрация")
        }

        btnLogin.setOnClickListener {
            showCredentials()
            tvAuthState.setText("Вход")
        }

        btnContinue.setOnClickListener {
            if (tvAuthState.text == "Вход") {
                doLogin()
            } else {
                doRegister()
            }
        }
    }

    private fun showCredentials() {
        listOf(tvTitle, btnRegister, btnLogin).forEach {
            it.visibility = View.GONE
        }

        clCredentials.visibility = View.VISIBLE

        etLogin.setText(listOf("DVegasa", "admin", "qwe", "nikita").random())
    }

    private fun doLogin() {
        btnContinue.isEnabled = false
        val login = etLogin.text.toString()
        val pass = etPassword.text.toString()
        RetrofitGenerator.retrofitClient.register(AuthRequest(login, pass))
            .enqueue(object : Callback<AuthRequest> {
                override fun onFailure(call: Call<AuthRequest>, t: Throwable) {
                    info(t)
                    MyApplication.username = login
                    startActivity(Intent(this@WelcomeActivity, MainActivity::class.java))
                }

                override fun onResponse(call: Call<AuthRequest>, response: Response<AuthRequest>) {
                    info(response.body())
                    MyApplication.username = login
                    startActivity(Intent(this@WelcomeActivity, MainActivity::class.java))
                }
            })
    }

    private fun doRegister() {
        val login = etLogin.text.toString()
        val pass = etPassword.text.toString()
        RetrofitGenerator.retrofitClient.register(AuthRequest(login, pass))
            .enqueue(object : Callback<AuthRequest> {
                override fun onFailure(call: Call<AuthRequest>, t: Throwable) {
                    info(t)
                    MyApplication.username = login
                    startActivity(Intent(this@WelcomeActivity, QuizStartActivity::class.java))
                }

                override fun onResponse(call: Call<AuthRequest>, response: Response<AuthRequest>) {
                    info(response.body())
                    MyApplication.username = login
                    startActivity(Intent(this@WelcomeActivity, QuizStartActivity::class.java))
                }
            })
    }
}