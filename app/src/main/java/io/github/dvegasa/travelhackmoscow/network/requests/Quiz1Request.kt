package io.github.dvegasa.travelhackmoscow.network.requests

/**
 * Created by Ed Khalturin @DVegasa
 */
data class Quiz1Request(
    val poiID: Long,
    val userID: String,
    val value: Int
)