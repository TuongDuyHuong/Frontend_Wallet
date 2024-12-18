package com.example.wallet5

import com.google.gson.annotations.SerializedName
import java.net.URL

data class PhoTo(
    @SerializedName("albumId")
    val albumId :Int,
    @SerializedName("id")
    val id:Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url : String,
    @SerializedName("thumbnailUrl")
    val thumbnailUrl : String
)