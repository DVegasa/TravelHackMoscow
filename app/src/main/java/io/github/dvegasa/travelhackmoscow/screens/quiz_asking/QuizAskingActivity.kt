package io.github.dvegasa.travelhackmoscow.screens.quiz_asking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.github.dvegasa.travelhackmoscow.R
import io.github.dvegasa.travelhackmoscow.helpers.fullscreen

class QuizAskingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_asking)
        fullscreen()

        loadQuiz()
    }

    fun loadQuiz() {
        // TODO LOAD QUIZ
    }

    fun nextQuestion() {

    }
}
