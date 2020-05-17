package com.andrius.forecastmvvm.data.provider

import com.andrius.forecastmvvm.internal.UnitSystem

interface UnitProvider {
    fun getUnitSystem(): UnitSystem
}