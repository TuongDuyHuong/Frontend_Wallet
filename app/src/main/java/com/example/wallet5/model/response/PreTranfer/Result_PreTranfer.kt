package com.example.wallet5.model.response.PreTranfer

import com.google.gson.annotations.SerializedName

class Result_PreTranfer(
    @SerializedName("userFrom")
    val userFrom: UserFrom_Result_PreTranfer,
    @SerializedName("amount")
    val amount: Double,
    @SerializedName("numberTo")
    val numberTo: String,
    @SerializedName("type")
    val type: Int,
    @SerializedName("userTo")
    val userTo: UserTo_Result_PreTranfer
) {
}