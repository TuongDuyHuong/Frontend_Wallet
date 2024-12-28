package com.example.wallet5.model.response

import com.example.wallet5.model.Result
import com.google.gson.annotations.SerializedName

class LoginResponse(
    @SerializedName("code")
    var code : Int,
    @SerializedName("message")
    var message : String,
    @SerializedName("result")
    var result : Result

) {
}