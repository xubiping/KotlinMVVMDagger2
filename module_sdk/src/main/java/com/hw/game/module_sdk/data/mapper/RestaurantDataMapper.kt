package com.hw.game.module_sdk.data.mapper

import com.hw.game.module_sdk.data.net.model.RestaurantDto
import com.hw.game.module_sdk.domain.model.Restaurant
import com.hw.game.module_sdk.data.db.model.RestaurantData
import javax.inject.Inject

class RestaurantDataMapper @Inject constructor() {

    fun dataToDomain(model: RestaurantData): Restaurant {
        return Restaurant(
            id = model.id,
            parentId = model.parentId,
            name = model.name,
            imageUrl = model.imageUrl,
            active = model.active,
            updatedAt = model.updatedAt,
        )
    }

    fun dataToDomainList (models: List<RestaurantData>): List<Restaurant> {
        return models.map { dataToDomain(it) }
    }

    fun domainToData(model: Restaurant): RestaurantData {
        return RestaurantData(
            id = model.id,
            parentId = model.parentId,
            name = model.name,
            imageUrl = model.imageUrl,
            active = model.active,
            updatedAt = model.updatedAt,
        )
    }

    fun dtoToDomain(model: RestaurantDto): Restaurant {
        return Restaurant(
            id = model.id,
            parentId = model.parentId,
            name = model.name,
            imageUrl = model.imageUrl,
            active = model.active,
            updatedAt = model.updatedAt,
        )
    }

    fun dtoToDomainList(models: List<RestaurantDto>): List<Restaurant> {
        return models.map { dtoToDomain(it) }
    }

}