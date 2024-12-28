package com.example.wallet5.model.request

import com.google.gson.annotations.SerializedName

class Bank(
    @SerializedName("phoneNumber")
    var phoneNumber :String,
    @SerializedName("infoBank")
    var infoBank :List<InforBank>
) {
}