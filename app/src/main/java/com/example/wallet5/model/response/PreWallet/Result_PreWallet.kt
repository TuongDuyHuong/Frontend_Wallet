package com.example.wallet5.model.response.PreWallet

import com.example.wallet5.model.response.PreTranfer.UserFrom_Result_PreTranfer
import com.example.wallet5.model.response.PreTranfer.UserTo_Result_PreTranfer
import com.google.gson.annotations.SerializedName

class Result_PreWallet(
    @SerializedName("userFrom")
    val userFrom: UserFrom_Wallet,
    @SerializedName("amount")
    val amount: Double,
    @SerializedName("nameTo")
    val nameTo: String,
    @SerializedName("numberFrom")
    val numberFrom: String,
    @SerializedName("userToW")
    val userToW: UserToW_Wallet,
    @SerializedName("numberTo")
    val numberTo: String,
    @SerializedName("type")
    val type: Int

) {
}