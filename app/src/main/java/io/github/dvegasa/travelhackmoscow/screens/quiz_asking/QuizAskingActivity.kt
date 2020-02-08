package io.github.dvegasa.travelhackmoscow.screens.quiz_asking

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.github.dvegasa.travelhackmoscow.R
import io.github.dvegasa.travelhackmoscow.helpers.FirstQuiz
import io.github.dvegasa.travelhackmoscow.helpers.fullscreen
import io.github.dvegasa.travelhackmoscow.pojos.SlideQuizData
import io.github.dvegasa.travelhackmoscow.screens.quiz_asking.quiz_fragments.SlideQuizFragment
import kotlinx.android.synthetic.main.activity_quiz_asking.*

class QuizAskingActivity : AppCompatActivity() {

    val quizes = ArrayList<FirstQuiz>()
    var currentQuestion = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_asking)
        fullscreen()

        loadQuiz()
    }

    private fun loadQuiz() {
        quizes.add(
            SlideQuizData(
                0,
                "Hello world",
                listOf("Слабо", "Нормально", "Обожаю"),
                listOf("Не моё. Не хочу", "Сойдёт. Почему бы и нет?", "АААА БОЖЕЧКИ МУР ^_^")
            )
        )
        nextQuestion()
    }

    fun nextQuestion() {
        currentQuestion++

        if (currentQuestion >= quizes.size) {
            sendAnswers()
        }
        when (quizes[currentQuestion]) {
            is SlideQuizData -> {
                supportFragmentManager.beginTransaction().apply {
                    replace(flQuiz.id, SlideQuizFragment())
                    commit()
                }
            }
        }
    }

    private fun sendAnswers() {

    }
}
