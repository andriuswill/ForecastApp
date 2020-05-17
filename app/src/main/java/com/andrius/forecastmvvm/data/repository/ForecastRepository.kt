package com.andrius.forecastmvvm.data.repository

import androidx.lifecycle.LiveData
import com.andrius.forecastmvvm.data.db.entity.WeatherLocation
import com.andrius.forecastmvvm.data.db.unitlocalized.UnitSpecificCurrentWeatherEntry

interface ForecastRepository {
    suspend fun getCurrentWeather(metric: Boolean): LiveData<out UnitSpecificCurrentWeatherEntry>
    suspend fun getWeatherlocation(): LiveData<WeatherLocation>
}