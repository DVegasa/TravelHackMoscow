package io.github.dvegasa.travelhackmoscow.screens.sequacfore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import io.github.dvegasa.travelhackmoscow.R
import kotlinx.android.synthetic.main.fragment_slide_quiz.*
import kotlinx.android.synthetic.main.fragment_slide_quiz.view.*


class SlideDaysFragment : Fragment() {

    lateinit var root: View
    lateinit var host: SequActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_slide_quiz, container, false)
        host = (activity as SequActivity)

        bindViews()
        updateUi(root.seekbar.progress)

        return root
    }


    private fun bindViews() {
        root.seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                updateUi(p1)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
        })

        root.tvTitle.text = "На сколько дней вы планируете свою поездку?"
        root.btnNext.setOnClickListener {
            host.nextQuestion(seekbar.progress)
        }
    }

    private fun updateUi(p: Int) {
        root.tvCloud.text = p.toString()

    }
}
