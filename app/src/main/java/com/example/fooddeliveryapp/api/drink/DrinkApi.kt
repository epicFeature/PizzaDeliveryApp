package com.example.fooddeliveryapp.api.drink

import com.example.fooddeliveryapp.api.common.model.FoodData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface DrinkApi {
    @Headers(
        "Accept: application/json",
        "Content-type: application/json"
    )
    @GET("mousePizzas/api/v1/menu/drink")

    fun getAll(): Call<FoodData>
}