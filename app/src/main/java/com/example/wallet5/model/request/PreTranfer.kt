package com.example.wallet5.model.request

import com.google.gson.annotations.SerializedName

class PreTranfer(
    @SerializedName("type")
    var type :String,
    @SerializedName("bankCode")
    var bankCode :String,
    @SerializedName("accountNumber")
    var accountNumber :String,
    @SerializedName("amount")
    var amount :String
) {
}