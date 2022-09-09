package com.hw.game.module_sdk.domain.interactor.meal

import com.falcon.restaurants.domain.model.Meal
import com.falcon.restaurants.domain.repository.MealRepository
import io.reactivex.Single
import javax.inject.Inject

class FetchMealsUseCase @Inject constructor(
    private val mealRepository: MealRepository
){
    fun execute(): Single<List<Meal>> = mealRepository.fetchMeals()
}