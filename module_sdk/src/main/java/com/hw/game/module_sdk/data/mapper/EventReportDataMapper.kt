package com.hw.game.module_sdk.data.mapper

import com.hw.game.module_sdk.data.db.model.EventReportData
import com.hw.game.module_sdk.domain.model.EventReport
import javax.inject.Inject

class EventReportDataMapper @Inject constructor() {
    fun dataToDomain(model: EventReportData): EventReport{
        return EventReport(
            id = model.id,
        timestamp = model.timestamp,//时间戳
        event_name  = model.event_name,//事件名
        event_extra  = model.event_extra,//事件数据
        platform_uid  = model.platform_uid,//平台uid
        updatedAt =  model.updatedAt,
        active =  model.active,
        server_id  = model.server_id,//
        server_name  = model.server_name,//
        role_id  = model.role_id,//
        role_name  = model.role_name,//
        role_level  = model.role_level,//
        remain_coin  = model.remain_coin,//
        )
    }
    fun dataToDomainList(models:List<EventReportData>):List<EventReport>{
        return models.map {
            dataToDomain(it)
        }
    }

    fun domainToData(model: EventReport): EventReportData{
        return EventReportData(
            id = model.id,
            timestamp = model.timestamp,//时间戳
            event_name  = model.event_name,//事件名
            event_extra  = model.event_extra,//事件数据
            platform_uid  = model.platform_uid,//平台uid
            updatedAt =  model.updatedAt,
            active =  model.active,
            server_id  = model.server_id,//
            server_name  = model.server_name,//
            role_id  = model.role_id,//
            role_name  = model.role_name,//
            role_level  = model.role_level,//
            remain_coin  = model.remain_coin,//
        )
    }
}