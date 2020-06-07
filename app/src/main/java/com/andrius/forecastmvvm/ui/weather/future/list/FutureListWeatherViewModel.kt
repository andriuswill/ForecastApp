package com.andrius.forecastmvvm.ui.weather.future.list

import com.andrius.forecastmvvm.data.provider.UnitProvider
import com.andrius.forecastmvvm.data.repository.ForecastRepository
import com.andrius.forecastmvvm.internal.lazyDeferred
import com.andrius.forecastmvvm.ui.base.WeatherViewModel
import org.threeten.bp.LocalDate

class FutureListWeatherViewModel(
    private val forecastRepository: ForecastRepository,
    unitProvider: UnitProvider
) : WeatherViewModel(forecastRepository, unitProvider) {

    val weatherEntries by lazyDeferred {
        val today = LocalDate.now()
        forecastRepository.getFutureWeatherList(today, super.isMetricUnit)
    }
}
