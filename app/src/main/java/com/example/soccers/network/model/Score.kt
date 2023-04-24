package com.example.soccers.network.model

import com.google.gson.annotations.SerializedName

data class Score(
    @SerializedName("extratime")
    val extratime: Extratime?,
    @SerializedName("Fulltime")
    val fulltime: Fulltime?,
    @SerializedName("Halftime")
    val halftime: Halftime?,
    @SerializedName("Penalty")
    val penalty: Penalty?
)