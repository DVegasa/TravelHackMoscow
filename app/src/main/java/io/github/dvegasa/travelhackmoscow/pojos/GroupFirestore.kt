package io.github.dvegasa.travelhackmoscow.pojos

import io.github.dvegasa.travelhackmoscow.helpers.GroupItem
import io.github.dvegasa.travelhackmoscow.helpers.MyApplication
import io.github.dvegasa.travelhackmoscow.network.responses.Poizz

/**
 * Created by Ed Khalturin @DVegasa
 */
data class GroupFirestore(
    val title: String = "",
    val description: String = "",
    val users: List<String> = listOf(), // # на конце означает что для этого юзера это инвайт
    val time: Long = System.currentTimeMillis(),
    var poizzes: Poizz? = null
) {
    fun toPojo(onlyMe: Boolean = true): GroupItem? {
        if (("${MyApplication.username}#" !in users)
            && ("${MyApplication.username}" !in users)
        )
            return null

        return if ("${MyApplication.username}#" in users) GroupInviteData(
            title,
            description,
            users[0].removeSuffix("#")
        ) else GroupNormalData(
            title,
            description
        )
    }
}