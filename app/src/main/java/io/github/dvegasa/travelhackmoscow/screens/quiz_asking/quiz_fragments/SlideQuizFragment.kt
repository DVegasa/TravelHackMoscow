package io.github.dvegasa.travelhackmoscow.screens.quiz_asking.quiz_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import io.github.dvegasa.travelhackmoscow.R
import io.github.dvegasa.travelhackmoscow.pojos.SlideQuizData
import io.github.dvegasa.travelhackmoscow.screens.quiz_asking.QuizAskingActivity
import kotlinx.android.synthetic.main.fragment_slide_quiz.view.*


class SlideQuizFragment : Fragment() {

    lateinit var root: View
    lateinit var quizData: SlideQuizData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_slide_quiz, container, false)

        getQuizData()
        bindViews()
        updateUi(root.seekbar.progress)

        return root
    }

    private fun getQuizData() {
        val host = (activity as QuizAskingActivity)
        quizData = host.quizes[host.currentQuestion] as SlideQuizData
    }

    private fun bindViews() {
        root.seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                updateUi(p1)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
        })

        root.tvTitle.text = quizData.title
    }

    private fun updateUi(p: Int) {
        val progress = p / 100
        root.apply {
            val state = when (progress) {
                in 0..3 -> 0
                in 4..7 -> 1
                else -> 2
            }

            tvCloud.text = quizData.cloudTexts[state]
            tvDescription.text = quizData.descriptionTexts[state]
        }

    }
}
