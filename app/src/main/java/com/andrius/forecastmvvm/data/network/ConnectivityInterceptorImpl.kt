package com.andrius.forecastmvvm.data.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import com.andrius.forecastmvvm.internal.NoConnectivityException
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException


class ConnectivityInterceptorImpl(context: Context) : ConnectivityInterceptor {

    private val appContext = context.applicationContext

    override fun intercept(chain: Interceptor.Chain): Response {
        if (!isOnline()){
            throw NoConnectivityException()
        }
        return chain.proceed(chain.request())
    }

    private fun isOnline(): Boolean {
        /*val connectivityManager = appContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return  networkInfo != null && networkInfo.isConnected*/
        val cm = appContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT < 23) {
            val ni = cm.activeNetworkInfo
            if (ni != null) {
                return ni.isConnected && (ni.type == ConnectivityManager.TYPE_WIFI || ni.type == ConnectivityManager.TYPE_MOBILE)
            }
        } else {
            cm.activeNetwork?.let { network ->
                cm.getNetworkCapabilities(network)?.let { networkCapabilities ->
                    return networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) || networkCapabilities.hasTransport(
                        NetworkCapabilities.TRANSPORT_WIFI
                    )
                }
            }
        }
        return false
    }


}