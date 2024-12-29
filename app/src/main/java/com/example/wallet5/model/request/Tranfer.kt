package com.example.wallet5.model.request

import com.example.wallet5.model.response.PreTranfer.UserFrom_Result_PreTranfer
import com.example.wallet5.model.response.PreTranfer.UserTo_Result_PreTranfer
import com.google.gson.annotations.SerializedName

class Tranfer(
    @SerializedName("otp")
    val otp :String,
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