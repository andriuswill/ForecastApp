package com.andrius.forecastmvvm.data.network.response

import com.andrius.forecastmvvm.data.db.entity.CurrentWeatherEntry
import com.andrius.forecastmvvm.data.db.entity.Location
import com.google.gson.annotations.SerializedName


data class CurrentWeatherResponse(
    //val location: Location,
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry
)