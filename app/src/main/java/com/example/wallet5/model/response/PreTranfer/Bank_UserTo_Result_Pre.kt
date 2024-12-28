package com.example.wallet5.model.response.PreTranfer

import com.google.gson.annotations.SerializedName

class Bank_UserTo_Result_Pre (
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("code")
    val code: String
        ){
}