package com.hw.game.module_sdk.data.repository

import com.hw.game.module_sdk.data.db.dao.EventReportDataDao
import com.hw.game.module_sdk.data.mapper.EventReportDataMapper
import com.hw.game.module_sdk.data.net.RetrofitInterface
import com.hw.game.module_sdk.domain.model.EventReport
import com.hw.game.module_sdk.domain.repository.EventReportRepository
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class EventReportRepositoryImpl @Inject constructor(
    val eventReportDataDao: EventReportDataDao,
    val retrofitInterface: RetrofitInterface,
    val eventReportMapper: EventReportDataMapper
) : EventReportRepository{

    val TAG: String = "EventReportRepositoryImpl"

    override fun getReportDatasByEventNameId(typeIDV: String): Observable<List<EventReport>> {
        return eventReportDataDao.getReportDatasByEventNameId(typeIDV).map {
            eventReportDatas->eventReportMapper.dataToDomainList(eventReportDatas)
        }
    }

    override fun getEventReportById(id: String): Single<EventReport> {
        return eventReportDataDao.getReportDataById(id).map {
                eventReportData -> eventReportMapper.dataToDomain(eventReportData)
        }
    }

    override fun upsert(eventReport: EventReport) {
        eventReportDataDao.upsert(eventReportMapper.domainToData(eventReport))
    }

    override fun upsert(eventReports: List<EventReport>): Completable {
        return Completable.fromAction{
            eventReports.map { upsert(it) }
        }
    }

    override fun fetchEventReports(): Single<List<EventReport>> {
        TODO("Not yet implemented")
    }

}