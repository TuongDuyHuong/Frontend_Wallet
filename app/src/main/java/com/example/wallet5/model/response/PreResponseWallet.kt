package com.example.wallet5.model.response

import com.example.wallet5.model.response.PreTranfer.Result_PreTranfer
import com.example.wallet5.model.response.PreWallet.Result_PreWallet
import com.google.gson.annotations.SerializedName

class PreResponseWallet(
    @SerializedName("code")
    var code : Int,
    @SerializedName("message")
    var message : String,
    @SerializedName("result")
    var result : Result_PreWallet
) {
}