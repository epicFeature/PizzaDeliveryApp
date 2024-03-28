package com.example.fooddeliveryapp.api.common

import com.example.fooddeliveryapp.App
import com.example.fooddeliveryapp.api.cache.CacheInterceptor
import com.example.fooddeliveryapp.api.cache.ForceCacheInterceptor
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File


object RetrofitInstance {

    private val client = OkHttpClient.Builder()
        .addInterceptor { chain ->
            chain.request().newBuilder()
                .addHeader("X-Jsio-Token", "c29b8555cb367093f5bf401ae4a562d5")
                .build()
                .let { chain.proceed(it) }
        }
        .cache(Cache(File(App.appContext.cacheDir, "http-cache"), 10L * 1024L * 1024L))
        .addNetworkInterceptor(CacheInterceptor())
        .addInterceptor(ForceCacheInterceptor())
        .build()

    val instance: Retrofit =
        Retrofit.Builder()
            .baseUrl("https://api.jsonserver.io")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
}