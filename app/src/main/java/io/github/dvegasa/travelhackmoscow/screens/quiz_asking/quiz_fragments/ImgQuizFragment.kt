package io.github.dvegasa.travelhackmoscow.screens.quiz_asking.quiz_fragments

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import io.github.dvegasa.travelhackmoscow.R
import io.github.dvegasa.travelhackmoscow.helpers.ImageHelper
import io.github.dvegasa.travelhackmoscow.pojos.ImgQuizData
import io.github.dvegasa.travelhackmoscow.screens.quiz_asking.QuizAskingActivity
import kotlinx.android.synthetic.main.black.view.*
import kotlinx.android.synthetic.main.fragment_img_quiz.view.*

class ImgQuizFragment : Fragment() {
    lateinit var root: View
    lateinit var host: QuizAskingActivity
    lateinit var quizData: ImgQuizData

    var state = 1
    val pickedIds = ArrayList<Long>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_img_quiz, container, false)
        host = activity as QuizAskingActivity
        getQuizData()
        bindViews()
        loadImages()
        return root
    }

    fun bindViews() {
        root.tvTitle.text = quizData.title

        root.apply {
            iv1.setOnClickListener {
                val v = LayoutInflater.from(this@ImgQuizFragment.host.baseContext)
                    .inflate(R.layout.black, iv1)
                v.tvNumber.text = state++.toString()
            }
            iv2.setOnClickListener {
                val v = LayoutInflater.from(this@ImgQuizFragment.host.baseContext)
                    .inflate(R.layout.black, iv2)
                v.tvNumber.text = state++.toString()
            }
            iv3.setOnClickListener {
                val v = LayoutInflater.from(this@ImgQuizFragment.host.baseContext)
                    .inflate(R.layout.black, iv3)
                v.tvNumber.text = state++.toString()
            }
            iv4.setOnClickListener {
                val v = LayoutInflater.from(this@ImgQuizFragment.host.baseContext)
                    .inflate(R.layout.black, iv4)
                v.tvNumber.text = state++.toString()
            }

        }
    }

    fun getQuizData() {
        quizData = host.quizes[host.currentQuestion] as ImgQuizData
    }

    fun loadImages() {
        val images = ArrayList<Bitmap>()
        for (i in 0..3) {
            Glide.with(this).asBitmap().load(quizData.urls[i])
                .into(object : CustomTarget<Bitmap>() {
                    override fun onLoadCleared(placeholder: Drawable?) {
                    }

                    override fun onResourceReady(
                        resource: Bitmap,
                        transition: Transition<in Bitmap>?
                    ) {
                        images.add(resource)
                        if (images.size >= 4) {

                            images.forEachIndexed { i, bitmap ->
                                images[i] = ImageHelper.getRoundedCornerBitmap(bitmap, 50)
                            }

                            root.iv1.background = BitmapDrawable(resources, images[0])
                            root.iv2.background = BitmapDrawable(resources, images[1])
                            root.iv3.background = BitmapDrawable(resources, images[2])
                            root.iv4.background = BitmapDrawable(resources, images[3])
                        }
                    }
                })
        }

    }
}


