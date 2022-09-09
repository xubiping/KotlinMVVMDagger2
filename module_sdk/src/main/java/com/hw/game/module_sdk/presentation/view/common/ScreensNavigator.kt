package com.hw.game.module_sdk.presentation.view.common

import androidx.appcompat.app.AppCompatActivity
import com.hw.game.module_sdk.presentation.di.activity.ActivityScope
import com.hw.game.module_sdk.presentation.view.meal.MealsActivity
import com.hw.game.module_sdk.presentation.view.mealdetail.MealDetailsActivity
import com.hw.game.module_sdk.presentation.view.restaurant.RestaurantsActivity
import javax.inject.Inject

/**
 * activity 跳转
 */
@ActivityScope
class ScreensNavigator @Inject constructor(val fromActivity:AppCompatActivity){
    fun toRestaurantsActivity(){
        RestaurantsActivity.start(fromActivity)
    }

    fun toMealsActivity(restaurantId: String) {
        MealsActivity.start(fromActivity, restaurantId)
    }

    fun toMealDetailsActivity(mealId: String){
        MealDetailsActivity.start(fromActivity, mealId)
    }
}