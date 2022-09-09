package com.hw.game.module_sdk.presentation.di.persentation

import com.hw.game.module_sdk.presentation.view.eventreport.EventreportsActivity
import com.hw.game.module_sdk.presentation.view.meal.MealsActivity
import com.hw.game.module_sdk.presentation.view.restaurant.RestaurantsActivity
import com.hw.game.module_sdk.presentation.view.splash.SplashActivity
import dagger.Subcomponent

@Subcomponent(modules = [PresentationModule::class])
interface PresentationComponent {
    fun inject(activity:SplashActivity)
    fun inject(activity:EventreportsActivity);
    fun inject(activity: MealsActivity)
    fun inject(activity: RestaurantsActivity)
    //fun inject(activity: MealDetailsActivity)
}