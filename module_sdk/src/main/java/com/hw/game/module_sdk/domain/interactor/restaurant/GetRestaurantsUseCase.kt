package com.hw.game.module_sdk.domain.interactor.restaurant

import com.hw.game.module_sdk.domain.model.Restaurant
import com.falcon.restaurants.domain.repository.RestaurantRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetRestaurantsUseCase @Inject constructor(
    private val restaurantRepository: RestaurantRepository
    ){

    fun execute(): Observable<List<Restaurant>> = restaurantRepository.getRestaurants()

}
