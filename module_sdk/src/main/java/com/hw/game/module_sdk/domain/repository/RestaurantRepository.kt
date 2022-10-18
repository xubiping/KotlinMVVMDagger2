package com.falcon.restaurants.domain.repository

import com.hw.game.module_sdk.domain.model.Restaurant
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

interface RestaurantRepository {

    fun getRestaurants(): Observable<List<Restaurant>>

    fun upsert(restaurant: Restaurant): Long

    fun upsert(restaurants: List<Restaurant>): Completable

    fun fetchRestaurants(): Single<List<Restaurant>>

}
