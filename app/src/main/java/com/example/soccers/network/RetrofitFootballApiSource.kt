package com.example.soccers.network

import com.example.soccers.core.handleApi
import com.example.soccers.core.network.model.NetworkResult
import com.example.soccers.network.model.FixtureResponce

class RetrofitFootballApiSource(private val apiFootball: ApiFootballService): ApiFootballSource {

    override suspend fun getFixtures(currentDate: String): NetworkResult<FixtureResponce>? {
        val result = handleApi {
            apiFootball.getFixtures(currentDate)
        }
        return result
    }


}