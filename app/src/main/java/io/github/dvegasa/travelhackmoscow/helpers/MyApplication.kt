package io.github.dvegasa.travelhackmoscow.helpers

import android.app.Application
import io.github.dvegasa.travelhackmoscow.pojos.GroupFirestore

/**
 * Created by Ed Khalturin @DVegasa
 */

class MyApplication : Application() {
    companion object Storage {
        var username: String = ""

        var selectedGroup: GroupFirestore? = null
    }
}