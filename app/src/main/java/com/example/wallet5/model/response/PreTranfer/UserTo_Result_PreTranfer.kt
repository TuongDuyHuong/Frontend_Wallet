package com.example.wallet5.model.response.PreTranfer

import com.example.wallet5.model.response.PreTranfer.Bank_UserTo_Result_Pre
import com.example.wallet5.model.response.PreTranfer.User_UserTo_Result_Pre
import com.google.gson.annotations.SerializedName

class UserTo_Result_PreTranfer(
    @SerializedName("id")
    val id: Int,
    @SerializedName("numberAccount")
    val numberAccount: String,
    @SerializedName("balance")
    val balance: Double,
    @SerializedName("bank")
    val bank: Bank_UserTo_Result_Pre

) {
}