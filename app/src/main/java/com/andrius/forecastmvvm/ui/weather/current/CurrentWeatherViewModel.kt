package com.andrius.forecastmvvm.ui.weather.current

import androidx.lifecycle.ViewModel;
import com.andrius.forecastmvvm.data.provider.UnitProvider
import com.andrius.forecastmvvm.data.repository.ForecastRepository
import com.andrius.forecastmvvm.internal.UnitSystem
import com.andrius.forecastmvvm.internal.lazyDeferred

class CurrentWeatherViewModel(
    private val forecastRepository: ForecastRepository,
    unitProvider: UnitProvider
) : ViewModel() {

    private val unitSystem = unitProvider.getUnitSystem()

    val isMetric: Boolean
        get() = unitSystem == UnitSystem.METRIC

    val weather by lazyDeferred {
        forecastRepository.getCurrentWeather(isMetric)
    }

    val weatherlocation by lazyDeferred {
        forecastRepository.getWeatherlocation()
    }}
