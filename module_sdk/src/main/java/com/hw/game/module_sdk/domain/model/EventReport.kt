package com.hw.game.module_sdk.domain.model

import androidx.annotation.NonNull
import androidx.room.PrimaryKey

data class EventReport (
    val id:String,
    val timestamp:Long,//时间戳
    val event_name :String,//事件名
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