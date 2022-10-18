package com.hw.game.sdk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.hw.game.module_sdk.presentation.view.splash.SplashActivity
import com.hw.game.sdk.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*binding = ActivityMainBinding.inflate(layoutInflater)
        binding.jump.setOnClickListener {
            Log.v("MainActivity","jump0")
            var intent = Intent(this, SplashActivity::class.java)
            startActivity(intent)
            Log.v("MainActivity","jump1")
        }*/
        var intent = Intent(this, SplashActivity::class.java)
        startActivity(intent)
       // Button jump = f
    }
}