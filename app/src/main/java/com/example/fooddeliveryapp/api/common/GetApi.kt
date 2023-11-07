package com.example.fooddeliveryapp.api.common

import com.example.fooddeliveryapp.api.common.model.FoodData
import retrofit2.Call

interface GetApi {

    fun getAll(): Call<FoodData>
}