package com.example.wallet5.model

import com.google.gson.annotations.SerializedName

data class Otp (
        @SerializedName("Key")
        val Key :Int,
        @SerializedName("numberTo")
        val numberTo : String

        )
