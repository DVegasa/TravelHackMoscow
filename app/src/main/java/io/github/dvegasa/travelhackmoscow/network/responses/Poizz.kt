package io.github.dvegasa.travelhackmoscow.network.responses


import com.google.gson.annotations.SerializedName

data class Poizz(
    @SerializedName("pois")
    val pois: List<Poi> = ArrayList<Poi>()
) {
    data class Poi(
        @SerializedName("address")
        val address: String = "",
        @SerializedName("description")
        val description: String = "",
        @SerializedName("id")
        val id: Int = 0,
        @SerializedName("name")
        val name: String = "",
        @SerializedName("type")
        val type: String = ""
    )
}