package com.sunnyweather.android.ui.place

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.core.content.ContextCompat.getSystemService
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.sunnyweather.android.R
import com.sunnyweather.android.SunnyWeatherApplication
import com.sunnyweather.android.databinding.ActivityWeatherBinding
import com.sunnyweather.android.databinding.PlaceItemBinding
import com.sunnyweather.android.logic.model.Place
import com.sunnyweather.android.ui.weather.WeatherActivity
import org.w3c.dom.Text

/**
 * Created by wuto on 2021-12-03.
 */
class PlaceAdapter(private val fragment: PlaceFragment,private val placeList:List<Place>):
RecyclerView.Adapter<PlaceAdapter.ViewHolder>(){

    inner class ViewHolder(binding:PlaceItemBinding):RecyclerView.ViewHolder(binding.root){
        val placeName:TextView = binding.placeName
        val placeAddress:TextView = binding.placeAddress
    }
//    inner class ViewHolder(view:View):RecyclerView.ViewHolder(view){
//        //能否绑定视图，不用findviewbyid
//        val placeName:TextView = view.findViewById(R.id.placeName)
//        val placeAddress:TextView = view.findViewById(R.id.placeAddress)
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.place_item,
//        parent,false)
//        return ViewHolder(view)
        val binding = PlaceItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
//        return ViewHolder(binding)
        val holder = ViewHolder(binding)
        holder.itemView.setOnClickListener {
            val position = holder.getBindingAdapterPosition()
            val place = placeList[position]
            val activity = fragment.activity
            if(activity is WeatherActivity){
//                activity.findViewById<DrawerLayout>(R.id.drawerLayout).closeDrawers()
                //用binding语法,因为binding属于私有属性,故在WeatherActivity中添加一个公共方法，逻辑为调用closeDrawers()方法
                activity.closeDrawers()
                activity.viewModel.locationLng = place.location.lng
                activity.viewModel.locationLat = place.location.lat
                activity.viewModel.placeName = place.name
                activity.refreshWeather()
            }else{
                val intent = Intent(parent.context, WeatherActivity::class.java).apply {
                    putExtra("location_lng", place.location.lng)
                    putExtra("location_lat", place.location.lat)
                    putExtra("place_name", place.name)
                }
                fragment.startActivity(intent)
                fragment.activity?.finish()
            }
            fragment.viewModel.savePlace(place)
        }
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val place = placeList[position]
        holder.placeName.text = place.name
        holder.placeAddress.text = place.address
    }

    override fun getItemCount()=placeList.size
}