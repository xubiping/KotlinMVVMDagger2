package com.hw.game.module_sdk.presentation.view.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.falcon.restaurants.domain.util.Logger
import com.hw.game.module_sdk.databinding.ActivitySplashBinding
import com.hw.game.module_sdk.presentation.view.common.BaseActivity
import com.hw.game.module_sdk.presentation.view.common.ScreensNavigator
import javax.inject.Inject

class SplashActivity :BaseActivity(){
    val TAG:String = "SplashActivity"
    lateinit var binding:ActivitySplashBinding
    @Inject lateinit var splashViewModel: SplashViewModel //这个viewmodel 是由SplashViewModelFactory 类创建的
    @Inject lateinit var screensNavigator: ScreensNavigator
    @Inject lateinit var layoutInflator: LayoutInflater
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presentationComponent.inject(this)//理解这里为什么传this。通过Component 找到最终关联的Activity
        binding = ActivitySplashBinding.inflate(layoutInflator)
        setContentView(binding.root)
        fetchAllData()
    }

    fun fetchAllData(){
        splashViewModel.fetchAllData(object : SplashViewModel.AllUpsertedListener{
            override fun onSuccess() {
                Logger.log( TAG,"onSuccess: ")
                screensNavigator.toRestaurantsActivity()
            }

            override fun onFailed(e: Throwable) {
                binding.progressBar.visibility = View.INVISIBLE
                val error:String?= e.localizedMessage
                Logger.log( TAG, "onFailed: $error")
                binding.errorTxt.text = error

            }

        })
    }

}