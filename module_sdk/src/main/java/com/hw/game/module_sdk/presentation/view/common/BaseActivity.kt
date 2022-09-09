package com.hw.game.module_sdk.presentation.view.common

import androidx.appcompat.app.AppCompatActivity
import com.hw.game.module_sdk.presentation.XSdkApplication
import com.hw.game.module_sdk.presentation.di.activity.ActivityModule
import com.hw.game.module_sdk.presentation.di.persentation.PresentationModule
//被继承的类一定要有open
open class BaseActivity : AppCompatActivity() {
    private val appComponent
        get() = (application as XSdkApplication).appComponent

    val activityComponent by lazy {
        appComponent.newActivityComponent(ActivityModule(this))
    }
    val presentationComponent by lazy {
        activityComponent.newPresentationComponent(PresentationModule())
    }

}