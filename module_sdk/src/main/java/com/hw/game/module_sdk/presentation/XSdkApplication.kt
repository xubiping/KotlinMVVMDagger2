package com.hw.game.module_sdk.presentation

import androidx.multidex.MultiDexApplication
import com.hw.game.module_sdk.presentation.di.app.AppModule
import com.hw.game.module_sdk.presentation.di.app.DaggerAppComponent

class XSdkApplication : MultiDexApplication() {

    val appComponent by lazy {
        DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
    }
}