package com.example.soccers.network.model

import com.google.gson.annotations.SerializedName

data class Periods(
    @SerializedName("first")
    val first: Long?,
    @SerializedName("second")
    val second: Long?
)