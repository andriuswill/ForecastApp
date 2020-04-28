package com.andrius.forecastmvvm.data.response

import com.andrius.forecastmvvm.data.db.CurrentWeatherEntry
import com.andrius.forecastmvvm.data.db.Location
import com.google.gson.annotations.SerializedName


data class CurrentWeatherResponse(
    val location: Location,
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry
)