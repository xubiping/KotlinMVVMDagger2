package com.hw.game.module_sdk.domain.interactor.meal
import com.hw.game.module_sdk.domain.model.Meal
import com.falcon.restaurants.domain.repository.MealRepository
import javax.inject.Inject
import io.reactivex.Single

class GetMealByIdUseCase @Inject constructor (
    private val mealRepository : MealRepository
    ) {

    fun execute(mealId: String): Single<Meal> = mealRepository.getMealById(mealId)

}
