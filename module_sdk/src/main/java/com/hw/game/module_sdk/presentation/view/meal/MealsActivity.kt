package com.hw.game.module_sdk.presentation.view.meal

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.falcon.restaurants.domain.util.Logger
import com.hw.game.module_sdk.R
import com.hw.game.module_sdk.databinding.ActivityMealDetailsBinding
import com.hw.game.module_sdk.databinding.ActivityMealsBinding
import com.hw.game.module_sdk.presentation.view.common.BaseActivity
import com.hw.game.module_sdk.presentation.view.common.ImageLoader
import com.hw.game.module_sdk.presentation.view.common.ScreensNavigator
import javax.inject.Inject

class MealsActivity : BaseActivity() {
    private var restaurantId: String = ""
    lateinit var adapter: MealsListAdapter
    lateinit var binding:ActivityMealsBinding

    @Inject lateinit var mealViewModel: MealViewModel
    @Inject lateinit var screensNavigator: ScreensNavigator
    @Inject lateinit var layoutInflator:LayoutInflater
    @Inject lateinit var imageLoader: ImageLoader

    companion object{
        const val RESTAURANT_ID: String = "RESTAURANT_ID"
        const val TAG: String = "MealsActivity"
        fun start(fromActivity: AppCompatActivity,restaurantId:String){
            Logger.log(TAG,"start: ")
            val intent = Intent(fromActivity,MealsActivity::class.java)//::class.java 代表？？
            intent.putExtra(RESTAURANT_ID,restaurantId)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presentationComponent.inject(this)
        binding = ActivityMealsBinding.inflate(layoutInflator)//ActivityMealsBinding 只对当MealsActivity前类有用，
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)//设置这个作用？？？可以不设置吗？？

        if(intent.hasExtra(RESTAURANT_ID)){
            restaurantId = intent.getStringExtra(RESTAURANT_ID)!!//这里为什么一定要!!
        }
        Logger.log( TAG,"onCreate: typeId: $restaurantId")
        adapter = MealsListAdapter(this,layoutInflator,imageLoader)// 为什么也用 layoutInflator

        adapter.onMealItemClicked = {mealId ->  screensNavigator.toMealDetailsActivity(mealId)}//输入为什么回自动弹出 mealId

        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = LinearLayoutManager(this)//LinearLayoutManager 作用

        setAdapterList()

    }
    fun setAdapterList() {
        mealViewModel.getMealsByRestaurantId(restaurantId).observe(this, { meals ->
            adapter.setList(meals)
        })
    }

    override fun onCreateOptionsMenu(menu: Menu) : Boolean{
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id: Int = item.getItemId()
        return super.onOptionsItemSelected(item)
    }

    override fun onPause() {
        super.onPause()
    }

}