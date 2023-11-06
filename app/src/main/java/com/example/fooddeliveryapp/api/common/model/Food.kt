package com.example.fooddeliveryapp.api.common.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Food(
    val id: Int,
    val name: String,
    val description: String,
    val price: Int,
    val photoUrl: String
)
