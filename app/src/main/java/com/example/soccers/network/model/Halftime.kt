package com.example.soccers.network.model

import com.google.gson.annotations.SerializedName

data class Halftime(
    @SerializedName("away")
    val away: Int?,
    @SerializedName("home")
    val home: Int?
)