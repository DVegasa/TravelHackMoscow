package io.github.dvegasa.travelhackmoscow.pojos

/**
 * Created by Ed Khalturin @DVegasa
 */
data class Poi (
    val title: String = "",
    val description: String = "",
    val address: String = "",
    val likes: Int = 0,
    val dislikes: Int = 0
)