package io.github.dvegasa.travelhackmoscow.pojos

import io.github.dvegasa.travelhackmoscow.helpers.GroupItem

/**
 * Created by Ed Khalturin @DVegasa
 */
data class GroupNormalData (
    val title: String,
    val description: String,
    val status: String,
    val userUrls: List<String>
) : GroupItem