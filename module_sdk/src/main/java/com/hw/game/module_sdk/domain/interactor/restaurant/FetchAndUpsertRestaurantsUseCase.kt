package com.hw.game.module_sdk.domain.interactor.restaurant

import io.reactivex.Completable
import javax.inject.Inject

class FetchAndUpsertRestaurantsUseCase @Inject constructor(
    private val fetchRestaurantsUseCase: FetchRestaurantsUseCase,
    private val upsertRestaurantsUseCase: UpsertRestaurantsUseCase
    ){

    fun execute(): Completable {
        return Completable.defer {
            fetchRestaurantsUseCase.execute().flatMapCompletable {
                    restaurants -> upsertRestaurantsUseCase.execute(restaurants)
            }
        }
    }

}
