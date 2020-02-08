package io.github.dvegasa.travelhackmoscow.pojos

import io.github.dvegasa.travelhackmoscow.helpers.QuizAnswer

/**
 * Created by Ed Khalturin @DVegasa
 */
data class ImgQuizAnswer(
    val pickedIds: ArrayList<Long>
) : QuizAnswer