package io.github.dvegasa.travelhackmoscow.pojos

import io.github.dvegasa.travelhackmoscow.helpers.QuizAnswer

/**
 * Created by Ed Khalturin @DVegasa
 */
data class SlideQuizAnswer (
    val id: Long,
    val value: Int // in 1..10
) : QuizAnswer