package com.example.wallet5.model

import com.google.gson.annotations.SerializedName

class Result_Bank (
    @SerializedName("id")
    val id: String,
    @SerializedName("numberAccount")
    val numberAccount: String,
    @SerializedName("code")
    val code: String,
    @SerializedName("balance")
    val balance: Double,
    @SerializedName("bankName")
    val bankName: String

        )