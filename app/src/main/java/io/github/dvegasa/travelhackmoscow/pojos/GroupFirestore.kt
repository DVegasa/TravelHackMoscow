package io.github.dvegasa.travelhackmoscow.pojos

import io.github.dvegasa.travelhackmoscow.helpers.GroupItem
import io.github.dvegasa.travelhackmoscow.helpers.MyApplication

/**
 * Created by Ed Khalturin @DVegasa
 */
data class GroupFirestore(
    val title: String = "",
    val description: String = "",
    val users: List<String> = listOf() // # на конце означает что для этого юзера это инвайт
) {
    fun toPojo(onlyMe: Boolean = true): GroupItem? {
        if (("${MyApplication.username}#" !in users)
            && ("${MyApplication.username}" !in users)
        )
            return null

        return if ("${MyApplication.username}#" in users) GroupInviteData(
            title,
            description,
            users[0].removeSuffix("#"),
            "https://img1.freepng.ru/20180327/bze/kisspng-computer-icons-user-profile-avatar-profile-5ab9e3b0310cb6.2741651015221318882009.jpg"
        ) else GroupNormalData(
            title,
            description,
            "Предстоящая поездка",
            ArrayList(users.size)
        )
    }
}