package com.example.wallet5.model.response

import com.example.wallet5.model.Result_Bank
import com.google.gson.annotations.SerializedName

class Bank_Connected (
        @SerializedName("code")
        var code : Int,
        @SerializedName("message")
        var message : String,
        @SerializedName("result")
        var result : List<Result_Bank>
        )
{
}