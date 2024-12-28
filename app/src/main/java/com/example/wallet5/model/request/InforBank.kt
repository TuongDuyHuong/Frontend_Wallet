package com.example.wallet5.model.request

import com.google.gson.annotations.SerializedName

class InforBank(
    @SerializedName("numberAccount")
    var numberAccount :String,
    @SerializedName("code")
    var code :String,
    @SerializedName("balance")
    var balance:String
) {
}