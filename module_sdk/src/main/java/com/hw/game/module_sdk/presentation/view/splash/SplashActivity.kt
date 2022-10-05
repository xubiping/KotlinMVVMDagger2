package com.hw.game.module_sdk.presentation.view.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.falcon.restaurants.domain.util.Logger
import com.hw.game.module_sdk.databinding.ActivitySplashBinding
import com.hw.game.module_sdk.presentation.view.common.BaseActivity
import com.hw.game.module_sdk.presentation.view.common.ScreensNavigator
import io.reactivex.plugins.RxJavaPlugins
import javax.inject.Inject

class SplashActivity : BaseActivity() {

    val TAG: String = "SplashActivity"
    lateinit var binding: ActivitySplashBinding

    @Inject lateinit var splashViewModel: SplashViewModel
    @Inject lateinit var screensNavigator: ScreensNavigator
    @Inject lateinit var layoutInflator: LayoutInflater

    override fun onCreate(savedInstanceState: Bundle?) {
        presentationComponent.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflator)
        setContentView(binding.root)
        fetchAllData()
    }

    fun fetchAllData() {
        RxJavaPlugins.setErrorHandler{ e -> { }}

        splashViewModel.fetchAllData(object : SplashViewModel.AllUpsertedListener {

            override fun onSuccess() {
                Logger.log( TAG,"onSuccess: ")
                //binding.progressBar.setProgress(100)
                //binding.progressBar.setVisibility(View.INVISIBLE)
                screensNavigator.toRestaurantsActivity()
            }

            override fun onFailed(e: Throwable) {
                binding.progressBar.setVisibility(View.INVISIBLE)
                val error: String? = e.localizedMessage
                Logger.log( TAG,"onFailed: " + error)
                binding.errorTxt.setText(error)
            }
        })
    }
}