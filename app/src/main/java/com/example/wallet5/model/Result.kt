package com.example.wallet5.model

import com.google.gson.annotations.SerializedName

class Result(
    @SerializedName("accessToken")
    val accessToken: String,
    @SerializedName("refreshToken")
    val refreshToken: String
) {
}