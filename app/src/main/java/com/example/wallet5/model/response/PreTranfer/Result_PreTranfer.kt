package com.example.wallet5.model.response.PreTranfer

import com.example.wallet5.model.response.UserToWallet
import com.google.gson.annotations.SerializedName

class Result_PreTranfer(
    @SerializedName("userFrom")
    val userFrom: UserFrom_Result_PreTranfer,
    @SerializedName("amount")
    val amount: Double,
    @SerializedName("nameTo")
    val nameTo: String,
    @SerializedName("numberFrom")
    val numberFrom: String,
    @SerializedName("numberTo")
    val numberTo: String,
    @SerializedName("type")
    val type: Int,
    @SerializedName("userTo")
    val userTo: UserTo_Result_PreTranfer

) {
}