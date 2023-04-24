package com.example.soccers.network

import com.example.soccers.core.network.model.NetworkResult
import com.example.soccers.network.model.FixtureResponce

interface ApiFootballSource {

    suspend fun getFixtures(currentDate: String): NetworkResult<FixtureResponce>?
}