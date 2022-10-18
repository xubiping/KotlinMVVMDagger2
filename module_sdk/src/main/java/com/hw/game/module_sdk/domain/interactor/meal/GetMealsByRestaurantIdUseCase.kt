package com.hw.game.module_sdk.domain.interactor.meal
import com.hw.game.module_sdk.domain.model.Meal
import com.falcon.restaurants.domain.repository.MealRepository
import javax.inject.Inject
import io.reactivex.Observable

class GetMealsByRestaurantIdUseCase @Inject constructor (
    private val mealRepository : MealRepository
    ) {

    fun execute (typeIdV: String): Observable<List<Meal>> = mealRepository.getMealsByRestaurantId(typeIdV)

}
