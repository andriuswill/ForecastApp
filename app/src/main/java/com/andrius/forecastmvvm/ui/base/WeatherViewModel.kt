package com.andrius.forecastmvvm.ui.base

import androidx.lifecycle.ViewModel
import com.andrius.forecastmvvm.data.provider.UnitProvider
import com.andrius.forecastmvvm.data.repository.ForecastRepository
import com.andrius.forecastmvvm.internal.UnitSystem
import com.andrius.forecastmvvm.internal.lazyDeferred

abstract class WeatherViewModel(
    private val forecastRepository: ForecastRepository,
    unitProvider: UnitProvider
) : ViewModel() {
    private val unitSystem = unitProvider.getUnitSystem()

    val isMetricUnit: Boolean
        get() = unitSystem == UnitSystem.METRIC

    val weatherlocation by lazyDeferred {
        forecastRepository.getWeatherlocation()
    }
}
