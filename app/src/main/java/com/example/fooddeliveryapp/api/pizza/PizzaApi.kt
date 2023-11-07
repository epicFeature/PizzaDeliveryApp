package com.example.fooddeliveryapp.api.pizza

import com.example.fooddeliveryapp.api.common.GetApi
import com.example.fooddeliveryapp.api.common.model.Food
import com.example.fooddeliveryapp.api.common.model.FoodData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers


interface PizzaApi: GetApi {

    @Headers(
        "Accept: application/json",
        "Content-type: application/json"
    )
    @GET("mousePizzas/api/v1/menu/pizza")
    override fun getAll(): Call<FoodData>
}