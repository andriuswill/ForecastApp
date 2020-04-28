package com.andrius.forecastmvvm

import android.app.Application
import com.andrius.forecastmvvm.data.db.ForescastDatabase
import com.andrius.forecastmvvm.data.db.ForescastDatabase_Impl
import com.andrius.forecastmvvm.data.network.*
import com.andrius.forecastmvvm.data.repository.ForecastRepository
import com.andrius.forecastmvvm.data.repository.ForecastRepositoryImpl
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

class ForecastApplication: Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@ForecastApplication))

        bind() from singleton { ForescastDatabase(instance()) }
        bind() from singleton { instance<ForescastDatabase>().currentWeatherDao()}
        bind<ConnectivityInterceptor>() with singleton { ConnectivityInterceptorImpl(instance()) }
        bind() from singleton {ApixuWeatherApiService(instance())}
        bind<WeatherNetworkDataSource>() with singleton { WeatherNetworkDataSourceImpl(instance()) }
        bind<ForecastRepository>() with singleton { ForecastRepositoryImpl(instance(),instance()) }

    }
}