package com.hw.game.module_sdk.data.net

import com.falcon.restaurants.data.net.model.MealDto
import com.falcon.restaurants.data.net.model.RestaurantDto
import io.reactivex.Single
import retrofit2.http.*

interface RetrofitInterface {

    @GET("api/getRestaurants.php")
    fun  fetchRestaurantDtos(@Query("maxUpdatedAt") maxUpdatedAt: String ): Single<List<RestaurantDto>>

    @GET("api/getMeals.php")
    fun fetchMealDtos(@Query("maxUpdatedAt") maxUpdatedAt: String): Single<List<MealDto>>

    @FormUrlEncoded
    @POST("api/login.php")
    fun login(@Field("name") name: String, @Field("password") password: String): Single<List<MealDto>>

    @FormUrlEncoded
    @POST("api/register.php")
    fun register(@Field("name") name: String,
                 @Field("email") email: String,
                 @Field("password") password: String): Single<List<MealDto>>
}