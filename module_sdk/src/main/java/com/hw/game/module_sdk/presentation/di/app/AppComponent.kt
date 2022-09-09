package com.hw.game.module_sdk.presentation.di.app

import com.hw.game.module_sdk.presentation.di.activity.ActivityComponent
import com.hw.game.module_sdk.presentation.di.activity.ActivityModule
import dagger.Component

@AppScope
@Component(modules = [AppModule::class])
interface AppComponent {
    fun newActivityComponent(activityModule: ActivityModule): ActivityComponent
}