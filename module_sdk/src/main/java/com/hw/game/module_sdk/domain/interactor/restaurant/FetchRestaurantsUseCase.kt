package com.hw.game.module_sdk.domain.interactor.restaurant

import com.hw.game.module_sdk.domain.model.Restaurant
import com.falcon.restaurants.domain.repository.RestaurantRepository
import io.reactivex.Single
import javax.inject.Inject

class FetchRestaurantsUseCase @Inject constructor(
    private val restaurantRepository: RestaurantRepository
    ){

    fun execute(): Single<List<Restaurant>> = restaurantRepository.fetchRestaurants()

}
