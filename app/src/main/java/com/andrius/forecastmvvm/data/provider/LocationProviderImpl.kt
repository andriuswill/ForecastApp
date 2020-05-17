package com.andrius.forecastmvvm.data.provider

import com.andrius.forecastmvvm.data.db.entity.WeatherLocation

class LocationProviderImpl : LocationProvider {

    override suspend fun hasLocationChanged(lastWeatherLocation: WeatherLocation): Boolean {
        return true
    }

    override suspend fun getPreferredLocationString(): String {
        return "Porto Alegre"
    }
}