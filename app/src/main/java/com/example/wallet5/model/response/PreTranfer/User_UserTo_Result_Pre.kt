package com.example.wallet5.model.response.PreTranfer

import com.google.gson.annotations.SerializedName

class User_UserTo_Result_Pre(
    @SerializedName("phoneNumber")
    val phoneNumber: String,
    @SerializedName("fullName")
    val fullName: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("userId")
    val userId: String,
    @SerializedName("wallet")
    val wallet: Wallet_User_UserTo_Result
) {
}