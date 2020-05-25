package com.andrius.forecastmvvm.data.network

import androidx.lifecycle.LiveData
import com.andrius.forecastmvvm.data.network.response.CurrentWeatherResponse
import com.andrius.forecastmvvm.data.network.response.FutureWeatherResponse

interface WeatherNetworkDataSource {

    val downloadedCurrentWeather: LiveData<CurrentWeatherResponse>
    val downloadedFutureWeather: LiveData<FutureWeatherResponse>

    suspend fun fetchCurrentWeather(
        location: String,
        languageCode: String
    )

    suspend fun fetchFutureWeather(
        location: String,
        languageCode: String
    )

}