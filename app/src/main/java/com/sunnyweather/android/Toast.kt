package com.sunnyweather.android

import android.widget.Toast

/**
 * Created by wuto on 2021-12-03.
 */
fun String.showToast(duration:Int=Toast.LENGTH_SHORT){
    Toast.makeText(SunnyWeatherApplication.context,this,duration).show()
}
fun Int.showToast(duration:Int=Toast.LENGTH_SHORT){
    Toast.makeText(SunnyWeatherApplication.context,this,duration).show()
}