package com.example.fooddeliveryapp.api.common

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


object RetrofitInstance {

    private val client = OkHttpClient.Builder()
        .addInterceptor { chain ->
            chain.request().newBuilder()
                .addHeader("X-Jsio-Token", "c29b8555cb367093f5bf401ae4a562d5")
                .build()
                .let { chain.proceed(it) }
        }
        .build()

    val instance: Retrofit =
        Retrofit.Builder()
            .baseUrl("https://api.jsonserver.io")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
}