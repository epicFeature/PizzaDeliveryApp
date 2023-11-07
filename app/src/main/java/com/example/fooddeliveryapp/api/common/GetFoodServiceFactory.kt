package com.example.fooddeliveryapp.api.common

import com.example.fooddeliveryapp.api.combo.ComboApi
import com.example.fooddeliveryapp.api.dessert.DessertApi
import com.example.fooddeliveryapp.api.drink.DrinkApi
import com.example.fooddeliveryapp.api.pizza.PizzaApi

class GetFoodServiceFactory private constructor() {
    private val retrofit = RetrofitInstance.instance
    private val pizzaApi = retrofit.create(PizzaApi::class.java)
    private val dessertApi = retrofit.create(DessertApi::class.java)
    private val comboApi = retrofit.create(ComboApi::class.java)
    private val drinkApi = retrofit.create(DrinkApi::class.java)

    fun getFoodData(foodType: FoodType) =
        when (foodType) {
            FoodType.PIZZA -> pizzaApi
            FoodType.DESSERT -> dessertApi
            FoodType.COMBO -> comboApi
            FoodType.DRINK -> drinkApi
        }.getAll()

    companion object {
        val instance = GetFoodServiceFactory()
    }
}

