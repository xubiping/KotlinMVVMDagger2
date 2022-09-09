package com.hw.game.module_sdk.data.db.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(indices = [Index(value = ["id"], unique = true)])
data class EventReportData(
    @PrimaryKey @NonNull val id:String,
    val timestamp:Long,//时间戳
    @NonNull val event_name :String,//事件名
    val event_extra :String,//事件数据
    val platform_uid :Int,//平台uid
    val updatedAt: String,
    val active: String,
    val server_id :String,//
    val server_name :String,//
    val role_id :String,//
    val role_name :String,//
    val role_level :String,//
    val remain_coin :String,//
)
