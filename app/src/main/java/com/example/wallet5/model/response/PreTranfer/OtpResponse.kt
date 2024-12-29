package com.example.wallet5.model.response.PreTranfer

import com.google.gson.annotations.SerializedName

data class OtpResponse (
        @SerializedName("code")
        val code :Int,
        @SerializedName("message")
        val message : String

        )
