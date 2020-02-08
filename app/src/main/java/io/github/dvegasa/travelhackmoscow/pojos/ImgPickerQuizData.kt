package io.github.dvegasa.travelhackmoscow.pojos

import io.github.dvegasa.travelhackmoscow.helpers.FirstQuiz

/**
 * Created by Ed Khalturin @DVegasa
 */
data class ImgPickerQuizData (
    val title: String,
    val images: List<ImgData>
) : FirstQuiz

data class ImgData (
    val url: String,
    val imgId: Long
)