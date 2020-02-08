package io.github.dvegasa.travelhackmoscow.helpers

import android.app.Activity
import android.graphics.Color
import android.util.Log
import android.view.View
import android.view.WindowManager

/**
 * Created by Ed Khalturin @DVegasa
 */
fun <T : Any> T.info(msg: Any?): T {
    Throwable().stackTrace[1].apply {
        Log.i(generateTag(), generateMessage(msg ?: "null"))
    }
    return this
}

fun <T : Any> T.logPoint(): T {
    Throwable().stackTrace[1].apply {
        Log.i(generateTag(), generateMessage("--LOGPOINT--"))
    }
    return this
}

fun StackTraceElement.generateTag() =
    "ed__ ${className.substringAfterLast(".")}.$methodName():$lineNumber"

fun StackTraceElement.generateMessage(msg: Any = "") = "$msg"

////////////////////////////////////////////////////////
// Fullscreen activity

fun Activity.fullscreen() {
    this.window.apply {
        clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        statusBarColor = Color.TRANSPARENT
    }
}
