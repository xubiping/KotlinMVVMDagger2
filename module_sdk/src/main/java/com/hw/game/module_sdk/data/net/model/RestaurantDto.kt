package com.hw.game.module_sdk.data.net.model

data class RestaurantDto(
    val id: String,
    val parentId: String,
    val name: String,
    val imageUrl: String,
    val active: String,
    val updatedAt: String
)