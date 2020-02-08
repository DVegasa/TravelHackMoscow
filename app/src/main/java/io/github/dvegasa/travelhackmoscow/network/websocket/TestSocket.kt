package io.github.dvegasa.travelhackmoscow.network.websocket

import io.github.dvegasa.travelhackmoscow.helpers.info
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener


/**
 * Created by Ed Khalturin @DVegasa
 */
class TestSocket : WebSocketListener() {
    lateinit var client: OkHttpClient

    override fun onOpen(webSocket: WebSocket, response: Response) {
        webSocket.send("Hello from android device")
    }

    override fun onMessage(webSocket: WebSocket, text: String) {
        super.onMessage(webSocket, text)
        info(text)
    }

    override fun onFailure(
        webSocket: WebSocket?,
        t: Throwable,
        response: Response?
    ) {
        info("Error : " + t.message)
    }
}