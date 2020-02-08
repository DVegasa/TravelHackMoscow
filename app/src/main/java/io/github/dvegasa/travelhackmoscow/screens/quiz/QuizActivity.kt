package io.github.dvegasa.travelhackmoscow.screens.quiz

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.github.dvegasa.travelhackmoscow.R
import io.github.dvegasa.travelhackmoscow.helpers.fullscreen
import kotlinx.android.synthetic.main.activity_quiz.*

class QuizActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        fullscreen()

        bindViews()
    }

    private fun bindViews() {
        ivNext.setOnClickListener {
            // Show quiz
        }
    }
}
