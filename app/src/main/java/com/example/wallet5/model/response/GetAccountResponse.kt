package com.example.wallet5.model.response

import com.example.wallet5.model.Result_GetAccount
import com.google.gson.annotations.SerializedName

class GetAccountResponse(
    @SerializedName("code")
    var code : Int,
    @SerializedName("message")
    var message : String,
    @SerializedName("result")
    var result : Result_GetAccount
) {
}