package com.sunnyweather.android

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

/**
 * Created by wuto on 2021-12-03.
 */
class SunnyWeatherApplication:Application() {

    companion object{
        const val TOKEN = "oJzStw12bp92ypAE"
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}