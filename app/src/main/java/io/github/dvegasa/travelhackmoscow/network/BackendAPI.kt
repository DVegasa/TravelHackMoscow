package io.github.dvegasa.travelhackmoscow.network

import io.github.dvegasa.travelhackmoscow.network.requests.AuthRequest
import io.github.dvegasa.travelhackmoscow.network.requests.Quiz1Request
import io.github.dvegasa.travelhackmoscow.network.requests.Quiz2Request
import io.github.dvegasa.travelhackmoscow.network.responses.Poizz
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by Ed Khalturin @DVegasa
 */
interface BackendAPI {
    @POST("account/register/")
    fun register(@Body user: AuthRequest): Call<AuthRequest>

    @POST("/rating/predict/")
    fun sendSecondQuiz(@Body quiz: Quiz2Request): Call<Poizz>

    @POST("/rating/set")
    fun sendFirstQuiz(@Body quiz: Quiz1Request): Call<Void>
}