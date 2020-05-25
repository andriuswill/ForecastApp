package com.andrius.forecastmvvm.ui.weather.current

import androidx.lifecycle.ViewModel;
import com.andrius.forecastmvvm.data.provider.UnitProvider
import com.andrius.forecastmvvm.data.repository.ForecastRepository
import com.andrius.forecastmvvm.internal.UnitSystem
import com.andrius.forecastmvvm.internal.lazyDeferred
import com.andrius.forecastmvvm.ui.base.WeatherViewModel

class CurrentWeatherViewModel(
    private val forecastRepository: ForecastRepository,
    unitProvider: UnitProvider
) : WeatherViewModel(forecastRepository, unitProvider) {

    val weather by lazyDeferred {
        forecastRepository.getCurrentWeather(super.isMetricUnit)
    }

}
