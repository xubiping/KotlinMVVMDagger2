package com.hw.game.module_sdk.domain.interactor.meal
import io.reactivex.Completable
import javax.inject.Inject

class FetchAndUpsertMealUseCase @Inject constructor (
        private val fetchMealsUseCase: FetchMealsUseCase,
        private val upsertMealsUseCase: UpsertMealsUseCase
    ) {

    fun execute(): Completable {
        return Completable.defer {
            fetchMealsUseCase.execute().flatMapCompletable {
                    meals -> upsertMealsUseCase.execute(meals)
            }
        }
    }

}
