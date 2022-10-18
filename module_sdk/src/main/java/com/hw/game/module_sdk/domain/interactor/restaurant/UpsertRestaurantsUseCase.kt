package com.hw.game.module_sdk.domain.interactor.restaurant

import com.hw.game.module_sdk.domain.model.Restaurant
import com.falcon.restaurants.domain.repository.RestaurantRepository
import io.reactivex.Completable
import javax.inject.Inject

class UpsertRestaurantsUseCase @Inject constructor(
        private val restaurantRepository: RestaurantRepository
    ){

    fun execute(restaurants: List<Restaurant>): Completable = restaurantRepository.upsert(restaurants)

}
