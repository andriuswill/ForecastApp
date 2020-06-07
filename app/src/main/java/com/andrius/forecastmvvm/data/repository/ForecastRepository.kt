package com.andrius.forecastmvvm.data.repository

import androidx.lifecycle.LiveData
import com.andrius.forecastmvvm.data.db.entity.WeatherLocation
import com.andrius.forecastmvvm.data.db.unitlocalized.current.UnitSpecificCurrentWeatherEntry
import com.andrius.forecastmvvm.data.db.unitlocalized.future.detail.UnitSpecificDetailFutureWeatherEntry
import com.andrius.forecastmvvm.data.db.unitlocalized.future.list.UnitSpecificSimpleFutureWeatherEntry
import org.threeten.bp.LocalDate

interface ForecastRepository {
    suspend fun getCurrentWeather(metric: Boolean): LiveData<out UnitSpecificCurrentWeatherEntry>

    suspend fun getFutureWeatherList(startDate: LocalDate, metric: Boolean): LiveData<out List<UnitSpecificSimpleFutureWeatherEntry>>

    suspend fun getFutureWeatherByDate(date: LocalDate, metric: Boolean): LiveData<out UnitSpecificDetailFutureWeatherEntry>

    suspend fun getWeatherlocation(): LiveData<WeatherLocation>
}