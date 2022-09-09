package com.hw.game.module_sdk.domain.repository

import com.hw.game.module_sdk.domain.model.EventReport
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

interface EventReportRepository {
    fun getReportDatasByEventNameId(typeIDV:String): Observable<List<EventReport>>
    fun getEventReportById(id:String):Single<EventReport>

    fun upsert(eventReport: EventReport)
    //Completable ??
    fun upsert(eventReports: List<EventReport>):Completable
    fun fetchEventReports():Single<List<EventReport>>


}