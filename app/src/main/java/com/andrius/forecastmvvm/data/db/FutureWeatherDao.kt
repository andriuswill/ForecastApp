package com.andrius.forecastmvvm.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.andrius.forecastmvvm.data.db.entity.FutureWeatherEntry
import com.andrius.forecastmvvm.data.db.unitlocalized.future.ImperialSpecificSimpleFutureWeatherEntry
import com.andrius.forecastmvvm.data.db.unitlocalized.future.MetricSpecificSimpleFutureWeatherEntry
import org.threeten.bp.LocalDate

@Dao
interface FutureWeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(futureWeatherEntries: List<FutureWeatherEntry>)

    @Query("select * from future_weather where date(date)  >= date(:startDate)")
    fun getSimpleWeatherForecastMetric(startDate: LocalDate): LiveData<MetricSpecificSimpleFutureWeatherEntry>

    @Query("select * from future_weather where date(date)  >= date(:startDate)")
    fun getSimpleWeatherForecastImperial(startDate: LocalDate): LiveData<ImperialSpecificSimpleFutureWeatherEntry>

    @Query("select count(id) from future_weather where date(date)  >= date(:startDate)")
    fun countFutureWeather(startDate: LocalDate): Int

    @Query("delete from future_weather where date(date)  < date(:firstDateToKeep)")
    fun deleteOldEntries(firstDateToKeep: LocalDate)
}