package com.example.wallet5.model.response

import com.google.gson.annotations.SerializedName

class DeleteBankResponse(
    @SerializedName("code")
    var code : Int,
    @SerializedName("message")
    var message : String
) {
}