package com.example.soccers.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    fun getInstance(): Retrofit {
        val okHttpLoggingInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)

        val myOkHttpClient = OkHttpClient
            .Builder()
            .addInterceptor(okHttpLoggingInterceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl("https://v3.football.api-sports.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(myOkHttpClient)
            .build()
    }
}