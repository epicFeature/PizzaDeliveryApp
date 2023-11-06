package com.example.fooddeliveryapp.api.combo

import com.example.fooddeliveryapp.api.common.model.FoodData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ComboApi {
    @Headers(
        "Accept: application/json",
        "Content-type: application/json"
    )
    @GET("mousePizzas/api/v1/menu/combo")

    fun getAll(): Call<FoodData>
}