package com.hw.game.module_sdk.data.mapper

import com.hw.game.module_sdk.data.net.model.MealDto
import com.hw.game.module_sdk.domain.model.Meal
import com.hw.game.module_sdk.data.db.model.MealData
import javax.inject.Inject

class MealDataMapper @Inject constructor() {

    fun dataToDomain(model: MealData): Meal {
        return Meal(
            id = model.id,
            name = model.name,
            details = model.details,
            imageUrl = model.imageUrl,
            restaurantId = model.restaurantId,
            updatedAt = model.updatedAt,
            active = model.active,
            favorite = model.favorite
        )
    }

    fun dataToDomainList (models: List<MealData>): List<Meal> {
        return models.map { dataToDomain(it) }
    }

    fun domainToData(model: Meal): MealData {
        return MealData(
            id = model.id,
            name = model.name,
            details = model.details,
            imageUrl = model.imageUrl,
            restaurantId = model.restaurantId,
            updatedAt = model.updatedAt,
            active = model.active,
            favorite = model.favorite
        )
    }

    fun dtoToDomain(model: MealDto): Meal {
        return Meal(
            id = model.id,
            name = model.name,
            details = model.details,
            imageUrl = model.imageUrl,
            restaurantId = model.restaurantId,
            updatedAt = model.updatedAt,
            active = model.active,
            favorite = model.favorite
        )
    }

    fun dtoToDomainList (models: List<MealDto>): List<Meal> {
        return models.map { dtoToDomain(it) }
    }

}