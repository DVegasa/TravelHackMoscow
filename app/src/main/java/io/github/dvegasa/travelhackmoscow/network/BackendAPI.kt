package io.github.dvegasa.travelhackmoscow.network

import io.github.dvegasa.travelhackmoscow.network.requests.AuthRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by Ed Khalturin @DVegasa
 */
interface BackendAPI {
    @POST("account/register/")
    fun register(@Body user: AuthRequest): Call<AuthRequest>
}