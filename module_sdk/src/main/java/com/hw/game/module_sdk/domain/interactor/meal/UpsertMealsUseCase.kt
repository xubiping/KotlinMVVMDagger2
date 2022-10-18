package com.hw.game.module_sdk.domain.interactor.meal
import com.hw.game.module_sdk.domain.model.Meal
import com.falcon.restaurants.domain.repository.MealRepository
import io.reactivex.Completable
import javax.inject.Inject

class UpsertMealsUseCase @Inject constructor (
    private val mealRepository : MealRepository
    ) {

    fun execute(meals: List<Meal>): Completable = mealRepository.upsert(meals)

}
