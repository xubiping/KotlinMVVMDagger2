package com.hw.game.module_sdk.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hw.game.module_sdk.data.db.dao.EventReportDataDao
import com.hw.game.module_sdk.data.db.dao.MealDataDao
import com.hw.game.module_sdk.data.db.dao.RestaurantDataDao
import com.hw.game.module_sdk.data.db.model.EventReportData
import com.hw.game.module_sdk.data.db.model.MealData
import com.hw.game.module_sdk.data.db.model.RestaurantData
//
@Database(entities = [MealData::class, RestaurantData::class, EventReportData::class], version = 1,exportSchema=false)
abstract class RoomDB : RoomDatabase() {
    abstract fun eventReportDao(): EventReportDataDao
    abstract fun mealDao(): MealDataDao
    abstract fun restaurantDao(): RestaurantDataDao

    companion object{
        @Volatile
        private var INSTANCE : RoomDB? = null

        fun getInstance(context: Context):RoomDB{
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RoomDB::class.java,
                    "xsdkroomdb.db"
                ).build()
                INSTANCE = instance
                instance//这个语法看不懂
            }
        }
    }
}