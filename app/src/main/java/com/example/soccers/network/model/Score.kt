package com.example.soccers.network.model

data class Score(
    val extratime: Extratime,
    val fulltime: Fulltime,
    val halftime: Halftime,
    val penalty: Penalty
)