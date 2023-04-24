package com.example.soccers.network.model

import com.google.gson.annotations.SerializedName

data class Paging(
    @SerializedName("current")
    val current: Int?,
    @SerializedName("total")
    val total: Int?
)