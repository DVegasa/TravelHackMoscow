package io.github.dvegasa.travelhackmoscow.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Ed Khalturin @DVegasa
 */
object RetrofitGenerator {
    var BASE_URL = "http://192.168.43.232:8000/"

    val retrofitClient : BackendAPI by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return@lazy retrofit.create(BackendAPI::class.java)
    }
}