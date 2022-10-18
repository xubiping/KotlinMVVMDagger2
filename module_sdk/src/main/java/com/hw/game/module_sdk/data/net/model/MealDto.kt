package com.hw.game.module_sdk.data.net.model;

data class MealDto(
    val id: String,
    val name : String,
    val details: String,
    val imageUrl: String,
    val restaurantId: String,
    val updatedAt: String,
    val active: String,
    val favorite: String
)
