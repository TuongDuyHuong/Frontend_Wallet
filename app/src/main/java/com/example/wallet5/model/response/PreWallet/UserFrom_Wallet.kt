package com.example.wallet5.model.response.PreWallet

import com.google.gson.annotations.SerializedName

class UserFrom_Wallet(
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