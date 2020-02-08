package io.github.dvegasa.travelhackmoscow.pojos

import io.github.dvegasa.travelhackmoscow.helpers.FirstQuiz

/**
 * Created by Ed Khalturin @DVegasa
 */
data class ImgQuizData (
    val quizId: Long,
    val title: String,
    val urls: List<String>,
    val imgIds: List<Long>
) : FirstQuiz