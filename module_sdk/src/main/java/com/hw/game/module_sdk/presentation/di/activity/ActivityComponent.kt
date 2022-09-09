package com.hw.game.module_sdk.presentation.di.activity

import com.hw.game.module_sdk.presentation.di.app.AppModule
import com.hw.game.module_sdk.presentation.di.persentation.PresentationComponent
import com.hw.game.module_sdk.presentation.di.persentation.PresentationModule
import dagger.Subcomponent

@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {
    fun newPresentationComponent(presentationModule: PresentationModule):PresentationComponent
}