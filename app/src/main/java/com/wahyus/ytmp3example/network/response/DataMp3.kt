package com.wahyus.ytmp3example.network.response

import com.google.gson.annotations.SerializedName

data class DataMp3(
    @field:SerializedName("length")
    val length: String,

    @field:SerializedName("link")
    val link: String,

    @field:SerializedName("size")
    val size: String,

    @field:SerializedName("title")
    val title: String
)