package com.example.soccers.network.model

import com.google.gson.annotations.SerializedName

data class Parameters(
    @SerializedName("live")
    val live: String?
)