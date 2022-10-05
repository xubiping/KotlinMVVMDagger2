package com.hw.game.module_sdk.presentation.view.splash

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hw.game.module_sdk.presentation.view.meal.MealViewModel
import com.hw.game.module_sdk.presentation.view.restaurant.RestaurantViewModel

class SplashViewModelFactory(
    var application: Application,
    var restaurantViewModel: RestaurantViewModel,
    var mealViewModel: MealViewModel
): ViewModelProvider.Factory {

    override fun <T :ViewModel> create(modelClass:  Class<T>) : T {
        return SplashViewModel(application, restaurantViewModel, mealViewModel) as T
    }
}