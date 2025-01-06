package com.example.wallet5.model.response.PreWallet

import com.example.wallet5.model.response.PreTranfer.Bank_UserTo_Result_Pre
import com.google.gson.annotations.SerializedName

class UserToW_Wallet(
    @SerializedName("id")
    val id: Int,
    @SerializedName("username")
    val username: String,
    @SerializedName("accountBalance")
    val accountBalance: Double,
    @SerializedName("transactions")
    val transactions: List<String>
) {
}