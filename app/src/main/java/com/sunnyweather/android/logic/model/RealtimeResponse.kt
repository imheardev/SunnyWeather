package com.sunnyweather.android.logic.model

import com.google.gson.annotations.SerializedName

/**
 * Created by wuto on 2021-12-04.
 */
class RealtimeResponse(val status: String, val result: Result) {

    class Result(val realtime: Realtime)

    class Realtime(val skycon: String, val temperature: Float,
                   @SerializedName("air_quality") val airQuality: AirQuality)

    class AirQuality(val aqi: AQI)

    class AQI(val chn: Float)

}