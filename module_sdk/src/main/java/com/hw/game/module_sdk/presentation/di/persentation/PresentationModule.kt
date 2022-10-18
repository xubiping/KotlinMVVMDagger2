package com.hw.game.module_sdk.presentation.di.persentation

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.hw.game.module_sdk.data.mapper.MealDataMapper
import com.hw.game.module_sdk.data.mapper.RestaurantDataMapper
import com.hw.game.module_sdk.data.repository.MealRepositoryImpl
import com.hw.game.module_sdk.domain.interactor.restaurant.FetchAndUpsertRestaurantsUseCase
import com.hw.game.module_sdk.domain.interactor.restaurant.GetRestaurantsUseCase
import com.falcon.restaurants.domain.repository.MealRepository
import com.falcon.restaurants.domain.repository.RestaurantRepository
import com.hw.game.module_sdk.data.db.RoomDB
import com.hw.game.module_sdk.data.db.dao.EventReportDataDao
import com.hw.game.module_sdk.data.db.dao.MealDataDao
import com.hw.game.module_sdk.data.db.dao.RestaurantDataDao
import com.hw.game.module_sdk.data.mapper.EventReportDataMapper
import com.hw.game.module_sdk.data.net.RetrofitInterface
import com.hw.game.module_sdk.data.repository.EventReportRepositoryImpl
import com.hw.game.module_sdk.data.repository.RestaurantRepositoryImpl
import com.hw.game.module_sdk.domain.interactor.meal.FetchAndUpsertMealUseCase
import com.hw.game.module_sdk.domain.interactor.meal.GetMealByIdUseCase
import com.hw.game.module_sdk.domain.interactor.meal.GetMealsByRestaurantIdUseCase
import com.hw.game.module_sdk.domain.repository.EventReportRepository
import com.hw.game.module_sdk.presentation.view.meal.MealViewModel
import com.hw.game.module_sdk.presentation.view.meal.MealViewModelFactory
import com.hw.game.module_sdk.presentation.view.restaurant.RestaurantViewModel
import com.hw.game.module_sdk.presentation.view.restaurant.RestaurantViewModelFactory
import com.hw.game.module_sdk.presentation.view.splash.SplashViewModel
import com.hw.game.module_sdk.presentation.view.splash.SplashViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class PresentationModule {

    // daos
    @Provides
    fun getMealDao(roomDB: RoomDB): MealDataDao = roomDB.mealDao()

    @Provides
    fun getRestaurantDao(roomDB: RoomDB): RestaurantDataDao = roomDB.restaurantDao()

    @Provides
    fun getEventReportDao(roomDB: RoomDB):EventReportDataDao = roomDB.eventReportDao()

    fun getEventReportRepository(
        reportDataDao: EventReportDataDao,
        retrofitInterface: RetrofitInterface,
        eventReportMapper: EventReportDataMapper
    ): EventReportRepository{
        return EventReportRepositoryImpl(reportDataDao,retrofitInterface,eventReportMapper)
    }
    @Provides
    fun getRestaurantRepository(
        restaurantDataDao: RestaurantDataDao,
        retrofitInterface: RetrofitInterface,
        restaurantDataMapper: RestaurantDataMapper
    ): RestaurantRepository {
        return RestaurantRepositoryImpl(restaurantDataDao, retrofitInterface, restaurantDataMapper)
    }

    @Provides
    fun getMealRepository(
        mealDataDao: MealDataDao,
        retrofitInterface: RetrofitInterface,
        mealDataMapper: MealDataMapper
    ): MealRepository {
        return MealRepositoryImpl(mealDataDao, retrofitInterface, mealDataMapper)
    }

    // view models
    @Provides
    fun getRestaurantViewModel(fragmentActivity: AppCompatActivity,
                               application: Application,
                               fetchAndUpsertRestaurantsUseCase: FetchAndUpsertRestaurantsUseCase,
                               getRestaurantsUseCase: GetRestaurantsUseCase
    ): RestaurantViewModel{

        return ViewModelProviders.of(
            fragmentActivity,
            RestaurantViewModelFactory(
                application,
                fetchAndUpsertRestaurantsUseCase,
                getRestaurantsUseCase
            )
        ).get(RestaurantViewModel::class.java)
    }

    @Provides
    fun getMealViewModel(fragmentActivity: AppCompatActivity,
                         application: Application,
                         fetchAndUpsertMealUseCase: FetchAndUpsertMealUseCase,
                         getMealsByRestaurantIdUseCase: GetMealsByRestaurantIdUseCase,
                         getMealByIdUseCase: GetMealByIdUseCase
    ): MealViewModel {

        return ViewModelProviders.of(
            fragmentActivity,
            MealViewModelFactory(
                application,
                fetchAndUpsertMealUseCase,
                getMealsByRestaurantIdUseCase,
                getMealByIdUseCase
            )
        ).get(MealViewModel::class.java)
    }

    @Provides
    fun getSplashViewModel (fragmentActivity: AppCompatActivity,
                            application: Application,
                            restaurantViewModel: RestaurantViewModel,
                            mealViewModel: MealViewModel
    ) : SplashViewModel {

        return ViewModelProviders.of(
            fragmentActivity,
            SplashViewModelFactory(application, restaurantViewModel, mealViewModel)
        ).get(SplashViewModel::class.java)
    }
}