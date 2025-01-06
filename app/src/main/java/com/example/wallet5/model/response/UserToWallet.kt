package com.example.wallet5.model.response

import com.google.gson.annotations.SerializedName

class UserToWallet(
    @SerializedName("code")
    var code : Int,
    @SerializedName("username")
    var username : String,
    @SerializedName("accountBalance")
    var accountBalance : String,
    @SerializedName("transactions")
    var transactions : List<String>

) {
}