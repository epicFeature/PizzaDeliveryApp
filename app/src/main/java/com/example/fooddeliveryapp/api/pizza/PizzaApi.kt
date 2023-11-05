package com.example.fooddeliveryapp.api.pizza

import com.example.fooddeliveryapp.api.common.model.Food
import retrofit2.Call


interface PizzaApi {

    fun getAll(): Call<List<Food>>
}