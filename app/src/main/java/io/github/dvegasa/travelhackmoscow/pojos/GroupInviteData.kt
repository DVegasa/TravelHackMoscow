package io.github.dvegasa.travelhackmoscow.pojos

import io.github.dvegasa.travelhackmoscow.helpers.GroupItem

/**
 * Created by Ed Khalturin @DVegasa
 */
data class GroupInviteData (
    val groupId: Long,
    val title: String,
    val description: String,
    val inviterName: String,
    val inviterUrl: String
) : GroupItem
