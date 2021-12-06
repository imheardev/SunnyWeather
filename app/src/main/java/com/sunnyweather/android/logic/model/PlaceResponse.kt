package com.sunnyweather.android.logic.model

import android.location.Location
import com.google.gson.annotations.SerializedName

/**
 * Created by wuto on 2021-12-03.
 */
data class PlaceResponse(val status:String,val places:List<Place>)

data class Place(val name:String,val location:com.sunnyweather.android.logic.model.Location,
@SerializedName("formatted_address") val address:String)

data class Location(val lng:String,val lat:String)