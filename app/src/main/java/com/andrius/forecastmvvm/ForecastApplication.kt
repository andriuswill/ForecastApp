package com.andrius.forecastmvvm

import android.app.Application
import android.content.Context
import androidx.preference.PreferenceManager
import com.andrius.forecastmvvm.data.db.ForescastDatabase
import com.andrius.forecastmvvm.data.db.ForescastDatabase_Impl
import com.andrius.forecastmvvm.data.network.*
import com.andrius.forecastmvvm.data.provider.LocationProvider
import com.andrius.forecastmvvm.data.provider.LocationProviderImpl
import com.andrius.forecastmvvm.data.provider.UnitProvider
import com.andrius.forecastmvvm.data.provider.UnitProviderImpl
import com.andrius.forecastmvvm.data.repository.ForecastRepository
import com.andrius.forecastmvvm.data.repository.ForecastRepositoryImpl
import com.andrius.forecastmvvm.ui.weather.current.CurrentWeatherViewModelFactory
import com.google.android.gms.location.LocationServices
import com.jakewharton.threetenabp.AndroidThreeTen
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class ForecastApplication: Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@ForecastApplication))

        bind() from singleton { ForescastDatabase(instance()) }
        bind() from singleton { instance<ForescastDatabase>().currentWeatherDao()}
        bind() from singleton { instance<ForescastDatabase>().weatherLocationDao()}

        bind<ConnectivityInterceptor>() with singleton { ConnectivityInterceptorImpl(instance()) }
        bind() from singleton {ApixuWeatherApiService(instance())}
        bind<WeatherNetworkDataSource>() with singleton { WeatherNetworkDataSourceImpl(instance()) }
        bind() from provider { LocationServices.getFusedLocationProviderClient(instance<Context>()) }
        bind<LocationProvider>() with singleton { LocationProviderImpl(instance(), instance()) }
        bind<ForecastRepository>() with singleton { ForecastRepositoryImpl(instance(),instance(), instance(), instance()) }
        bind<UnitProvider>() with singleton { UnitProviderImpl(instance()) }
        bind() from provider { CurrentWeatherViewModelFactory(instance(), instance()) }
    }

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
        PreferenceManager.setDefaultValues(this, R.xml.preferences, false)
    }
}