package com.example.soccers.network.model

import com.google.gson.annotations.SerializedName

data class Penalty(
    @SerializedName("away")
    val away: Int?,
    val home: Int?
)