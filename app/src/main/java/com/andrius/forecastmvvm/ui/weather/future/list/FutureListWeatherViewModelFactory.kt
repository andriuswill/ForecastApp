package com.andrius.forecastmvvm.ui.weather.future.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.andrius.forecastmvvm.data.provider.UnitProvider
import com.andrius.forecastmvvm.data.repository.ForecastRepository
import com.andrius.forecastmvvm.internal.lazyDeferred
import com.andrius.forecastmvvm.ui.base.WeatherViewModel
import org.threeten.bp.LocalDate

class FutureListWeatherViewModelFactory(
    private val forecastRepository: ForecastRepository,
    private val unitProvider: UnitProvider
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FutureListWeatherViewModel(
            forecastRepository,
            unitProvider
        ) as T
    }


}
