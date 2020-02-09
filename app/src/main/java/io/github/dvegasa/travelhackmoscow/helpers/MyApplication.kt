package io.github.dvegasa.travelhackmoscow.helpers

import android.app.Application

/**
 * Created by Ed Khalturin @DVegasa
 */

class MyApplication : Application() {
    companion object Storage {
        var username: String = ""

        var selectedGroup: GroupItem? = null
    }
}