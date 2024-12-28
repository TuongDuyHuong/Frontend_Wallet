package com.example.wallet5.model.response

import com.example.wallet5.model.response.PreTranfer.Result_PreTranfer
import com.google.gson.annotations.SerializedName

class PreTranferResponse(
    @SerializedName("code")
    var code : Int,
    @SerializedName("message")
    var message : String,
    @SerializedName("result")
    var result : Result_PreTranfer
) {
}