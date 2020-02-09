package io.github.dvegasa.travelhackmoscow.helpers

import android.app.Application
import com.google.firebase.firestore.FirebaseFirestore

/**
 * Created by Ed Khalturin @DVegasa
 */

class MyApplication : Application() {
    companion object Storage {
        var username: String = ""

        var selectedGroup: FirebaseFirestore? = null
    }
}