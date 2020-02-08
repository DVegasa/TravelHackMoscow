package io.github.dvegasa.travelhackmoscow.screens.quiz_start

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.github.dvegasa.travelhackmoscow.R
import io.github.dvegasa.travelhackmoscow.helpers.fullscreen
import io.github.dvegasa.travelhackmoscow.screens.quiz_asking.QuizAskingActivity
import kotlinx.android.synthetic.main.activity_quiz_start.*

class QuizStartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_start)
        fullscreen()

        bindViews()
    }

    private fun bindViews() {
        ivNext.setOnClickListener {
            startActivity(Intent(this, QuizAskingActivity::class.java))
        }
    }
}
