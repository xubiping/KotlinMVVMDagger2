package com.hw.game.module_sdk.data.repository

import com.hw.game.module_sdk.data.mapper.RestaurantDataMapper
import com.hw.game.module_sdk.domain.model.Restaurant
import com.falcon.restaurants.domain.repository.RestaurantRepository
import com.hw.game.module_sdk.data.db.dao.RestaurantDataDao
import com.hw.game.module_sdk.data.net.RetrofitInterface
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject


class RestaurantRepositoryImpl @Inject constructor(
    val restaurantDataDao: RestaurantDataDao,
    val retrofitInterface: RetrofitInterface,
    var restaurantDataMapper: RestaurantDataMapper

    ) : RestaurantRepository{

    val TAG: String = "RestaurantRepositoryImpl"

    override fun getRestaurants(): Observable<List<Restaurant>> =
        restaurantDataDao.getRestaurants().map {
            restaurantDatas -> restaurantDataMapper.dataToDomainList(restaurantDatas)
        }

    override fun upsert(restaurant: Restaurant): Long = restaurantDataDao.upsert(
        restaurantDataMapper.domainToData(restaurant)
    )

    override fun upsert(restaurants: List<Restaurant>): Completable {
        return Completable.fromAction { restaurants.map { upsert(it) }
        }
    }

    override fun fetchRestaurants(): Single<List<Restaurant>> {
        val maxUpdatedAt: String = restaurantDataDao.getMaxUpdated()
        // may use this for test: val maxUpdatedAt: String = "1970-01-01 00:00:01"
        return retrofitInterface.fetchRestaurantDtos(maxUpdatedAt).map {
                restaurantDtos -> restaurantDataMapper.dtoToDomainList(restaurantDtos)
        }
    }

}
