package com.example.wallet5.model.request

import com.google.gson.annotations.SerializedName

data class Register(
    @SerializedName("username")
    val username :String,
    @SerializedName("password")
    val password :String,
    @SerializedName("email")
    val email :String,
    @SerializedName("firstName")
    val firstName :String,
    @SerializedName("lastName")
    val lastName :String,
    @SerializedName("phoneNumber")
    val phoneNumber :String
) {
}