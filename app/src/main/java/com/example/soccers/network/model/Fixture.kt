package com.example.soccers.network.model

import com.google.gson.annotations.SerializedName

data class Fixture(
    @SerializedName("date")
    val date: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("periods")
    val periods: Periods?,
    @SerializedName("referee")
    val referee: String?,
    @SerializedName("status")
    val status: Status?,
    @SerializedName("timestamp")
    val timestamp: Long?,
    @SerializedName("timezone")
    val timezone: String?,
    @SerializedName("venue")
    val venue: Venue?
)