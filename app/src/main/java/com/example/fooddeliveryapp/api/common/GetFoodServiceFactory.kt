package com.example.fooddeliveryapp.api.common

import com.example.fooddeliveryapp.api.pizza.PizzaApi

class GetFoodServiceFactory private constructor() {
    private val retrofit = RetrofitInstance.instance
    private val pizzaApi = retrofit.create(PizzaApi::class.java)
    private val desertApi = retrofit.create(PizzaApi::class.java)
    private val comboApi = retrofit.create(PizzaApi::class.java)
    private val drinkApi = retrofit.create(PizzaApi::class.java)

    fun getFoodData(foodType: FoodType) =
        when (foodType) {
            FoodType.PIZZA -> pizzaApi
            FoodType.DESSERT -> desertApi
            FoodType.COMBO -> comboApi
            FoodType.DRINK -> drinkApi
        }.getAll()

    companion object {
        val instance = GetFoodServiceFactory()
    }
}

