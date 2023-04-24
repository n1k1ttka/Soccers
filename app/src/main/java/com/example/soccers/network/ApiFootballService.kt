package com.example.soccers.network

import com.example.soccers.network.model.FixtureResponce
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiFootballService {

    @Headers("Content-Type: application/json", "x-apisports-key: 156631943cb79509a53db5af5eff4c5b")
    @GET("fixtures/")
    suspend fun getFixtures(@Query("date") date: String): Response<FixtureResponce>
}