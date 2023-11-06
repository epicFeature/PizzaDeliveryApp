package com.example.fooddeliveryapp.api.common.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FoodData(
    val data: List<Food>
)