package com.example.wallet5.model.request

import com.example.wallet5.model.response.PreTranfer.UserFrom_Result_PreTranfer
import com.example.wallet5.model.response.PreTranfer.UserTo_Result_PreTranfer
import com.example.wallet5.model.response.PreWallet.UserFrom_Wallet
import com.example.wallet5.model.response.PreWallet.UserToW_Wallet
import com.example.wallet5.model.response.UserToWallet
import com.google.gson.annotations.SerializedName

class TranferWallet(
    @SerializedName("otp")
    val otp :String,
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