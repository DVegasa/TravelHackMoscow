package io.github.dvegasa.travelhackmoscow.pojos

import io.github.dvegasa.travelhackmoscow.helpers.FirstQuiz
import io.github.dvegasa.travelhackmoscow.helpers.SecondQuiz

/**
 * Created by Ed Khalturin @DVegasa
 */
data class SlideQuizData (
    val quizId: Long,
    val title: String,
    val cloudTexts: List<String>,
    val descriptionTexts: List<String>
) : FirstQuiz, SecondQuiz
