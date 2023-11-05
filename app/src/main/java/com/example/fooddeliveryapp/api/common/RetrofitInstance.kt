package com.example.fooddeliveryapp.api.common

import com.example.fooddeliveryapp.api.pizza.PizzaApi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


object RetrofitInstance {

    private const val BASE_URL = "https://api.jsonserver.io/mousePizzas/api/v1/menu/pizza"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(
            MoshiConverterFactory.create()
        )
        .build()

    val pizzaApi: PizzaApi = retrofit.create(PizzaApi::class.java)

}