package com.hw.game.module_sdk.presentation.view.restaurant

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hw.game.module_sdk.domain.interactor.restaurant.FetchAndUpsertRestaurantsUseCase
import com.hw.game.module_sdk.domain.interactor.restaurant.GetRestaurantsUseCase

class RestaurantViewModelFactory(
    var application: Application,
    var fetchAndUpsertRestaurantsUseCase: FetchAndUpsertRestaurantsUseCase,
    val getRestaurantsUseCase: GetRestaurantsUseCase

) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return RestaurantViewModel(
            application,
            fetchAndUpsertRestaurantsUseCase,
            getRestaurantsUseCase
        ) as T
    }
}