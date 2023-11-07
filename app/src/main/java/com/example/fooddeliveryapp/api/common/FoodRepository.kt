package com.example.fooddeliveryapp.api.common

object FoodRepository {

    private val factory = GetFoodServiceFactory.instance

    fun getAll(foodType: FoodType) = factory.getFoodData(foodType)
}