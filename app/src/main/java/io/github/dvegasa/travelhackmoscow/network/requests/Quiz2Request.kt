package io.github.dvegasa.travelhackmoscow.network.requests

/**
 * Created by Ed Khalturin @DVegasa
 */

data class Quiz2Request (
    val days: Int,
    val users: List<String>,
    val filter: String
)