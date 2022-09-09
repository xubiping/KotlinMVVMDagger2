package com.hw.game.module_sdk.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.hw.game.module_sdk.data.db.model.EventReportData
import io.reactivex.Observable
import io.reactivex.Single

@Dao
abstract class EventReportDataDao : BaseDao<EventReportData>(){

    @Query("SELECT * from EventReportData WHERE event_name=:typeIdV ORDER BY updatedAt ASC")
    abstract fun getReportDatasByEventNameId(typeIdV: String): Observable<List<EventReportData>>

    @Query("SELECT * from EventReportData WHERE id=:ReportDataIdV")
    abstract fun getReportDataById(ReportDataIdV: String): Single<EventReportData>

    @Query("SELECT MAX(updatedAt) from EventReportData WHERE  active=1")
    abstract override fun getMaxUpdatedAt(): String

    // *** check exists
    @Query("SELECT EXISTS(SELECT * FROM EventReportData WHERE id = :idV)")
    abstract fun checkExists(idV: String): Boolean

    override fun checkExists(eventReportData: EventReportData): Boolean{
        return checkExists(eventReportData.id)
    }

}