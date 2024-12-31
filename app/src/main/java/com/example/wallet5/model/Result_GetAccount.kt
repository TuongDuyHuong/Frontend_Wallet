package com.example.wallet5.model

import com.google.gson.annotations.SerializedName

class Result_GetAccount(
    @SerializedName("id")
    val id: Int,
    @SerializedName("username")
    val username: String,
    @SerializedName("accountBalance")
    val accountBalance: String,
    @SerializedName("transactions")
    val transactions: List<String>
) {
}