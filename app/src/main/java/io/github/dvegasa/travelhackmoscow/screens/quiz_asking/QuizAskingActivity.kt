package io.github.dvegasa.travelhackmoscow.screens.quiz_asking

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.github.dvegasa.travelhackmoscow.R
import io.github.dvegasa.travelhackmoscow.helpers.*
import io.github.dvegasa.travelhackmoscow.network.RetrofitGenerator
import io.github.dvegasa.travelhackmoscow.network.requests.Quiz1Request
import io.github.dvegasa.travelhackmoscow.pojos.ImgQuizAnswer
import io.github.dvegasa.travelhackmoscow.pojos.ImgQuizData
import io.github.dvegasa.travelhackmoscow.pojos.SlideQuizAnswer
import io.github.dvegasa.travelhackmoscow.pojos.SlideQuizData
import io.github.dvegasa.travelhackmoscow.screens.main.MainActivity
import io.github.dvegasa.travelhackmoscow.screens.quiz_asking.quiz_fragments.ImgQuizFragment
import io.github.dvegasa.travelhackmoscow.screens.quiz_asking.quiz_fragments.SlideQuizFragment
import kotlinx.android.synthetic.main.activity_quiz_asking.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QuizAskingActivity : AppCompatActivity() {

    val quizes = ArrayList<FirstQuiz>()
    var currentQuestion = -1

    private val answers = ArrayList<QuizAnswer>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_asking)
        fullscreen()

        loadQuiz()
    }

    private fun loadQuiz() {
        quizes.add(
            SlideQuizData(
                0, // ID
                "Насколько вы любите ходить пешком?", // Title
                listOf("Слабо", "Нормально", "Обожаю"), // Облако
                listOf("Очень не люблю", "Сойдёт. Почему бы и нет?", "Люблю отлично прогуляться!") // Снизу
            )
        )
        quizes.add(
            SlideQuizData(
                1, // ID
                "Насколько вы любите архитектуру?", // Title
                listOf("Не хочу", "Нейтрально", "Обожаю"), // Облако
                listOf("Очень не люблю", "Можно и посмотреть", "Жить без этого не могу!") // Снизу
            )
        )

        quizes.add(
            ImgQuizData(
                2, // ID вопроса
                "Нажми на картинки в том порядке, в каком они тебе нравятся", // Title
                listOf(
                    "https://picsum.photos/id/${(1..200).random()}/200/200",
                    "https://picsum.photos/id/${(1..200).random()}/200/200",
                    "https://picsum.photos/id/${(1..200).random()}/200/200",
                    "https://picsum.photos/id/${(1..200).random()}/200/200"
                ),
                listOf(11, 22, 33, 44) // ID картинок
            )
        )
        nextQuestion()
    }

    fun nextQuestion() {
        currentQuestion++

        if (currentQuestion > 0) {
            var poiID = (currentQuestion - 1).toLong()
            val userID = MyApplication.Storage.username
            if (poiID != 2L) {
                val value = (answers[poiID.toInt()] as SlideQuizAnswer).value
                RetrofitGenerator.retrofitClient.sendFirstQuiz(Quiz1Request(poiID, userID, value)).enqueue(
                    object : Callback<Void> {
                        override fun onFailure(call: Call<Void>, t: Throwable) {
                        }

                        override fun onResponse(call: Call<Void>, response: Response<Void>) {
                        }
                    }
                )
            } else {
                var a = 9
                for (imgId in (answers[2] as ImgQuizAnswer).pickedIds) {
                    poiID = imgId
                    val value = a
                    RetrofitGenerator.retrofitClient.sendFirstQuiz(Quiz1Request(poiID, userID, value)).enqueue(
                        object : Callback<Void> {
                            override fun onFailure(call: Call<Void>, t: Throwable) {
                            }

                            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                            }
                        }
                    )
                    a -= 3
                }
            }

        }

        if (currentQuestion >= quizes.size) {
            sendAnswers()
            startActivity(Intent(this, MainActivity::class.java))
            return
        }

        tvQuestionsLeft.text = "Вопрос ${currentQuestion + 1} из ${quizes.size}"

        supportFragmentManager.beginTransaction().apply {
            replace(
                flQuiz.id, when (quizes[currentQuestion]) {
                    is ImgQuizData -> ImgQuizFragment()
                    is SlideQuizData -> SlideQuizFragment()
                    else -> throw Exception("Bad QuizData")
                }
            )
            commit()
        }
    }


    fun addAnswer(answer: QuizAnswer) {
        answers.add(answer)
    }

    private fun sendAnswers() {
        info(answers)
    }
}
