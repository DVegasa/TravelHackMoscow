package io.github.dvegasa.travelhackmoscow.screens.welcome

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import io.github.dvegasa.travelhackmoscow.R
import io.github.dvegasa.travelhackmoscow.helpers.fullscreen
import io.github.dvegasa.travelhackmoscow.screens.quiz_start.QuizStartActivity
import kotlinx.android.synthetic.main.activity_welcome.*


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
    }

    private fun doLogin() {
        val login = etLogin.text.toString()
        val pass = etPassword.text.toString()
        // TODO LOGIN

        nextScreen()
    }

    private fun doRegister() {
        val login = etLogin.text.toString()
        val pass = etPassword.text.toString()
        // TODO LOGIN

        nextScreen()
    }

    private fun nextScreen() {
        startActivity(Intent(this, QuizStartActivity::class.java))
    }
}