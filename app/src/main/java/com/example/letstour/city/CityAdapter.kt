package com.example.letstour

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.letstour.city.City

class CityAdapter(
    val context:Context,
    var cityList:List<City>
):RecyclerView.Adapter<CityAdapter.CityViewHolder>() {
    inner class CityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var currentPosition:Int = -1
        private var currentCity:City?   = null

        private  val txvCityName = itemView.findViewById<TextView>(R.id.txv_city_name)
        private  val imvCityImage = itemView.findViewById<TextView>(R.id.imv_city)
        private  val imvDelete = itemView.findViewById<TextView>(R.id.imv_delete)
        private  val imvFavorite = itemView.findViewById<TextView>(R.id.imv_favorite)

        fun setData(city:City, position: Int){
            this.currentPosition = position
            this.currentCity     = city
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_city,parent,false)
        return CityViewHolder(view)
    }

    override fun onBindViewHolder(cityViewHolder: CityViewHolder, position: Int) {
        val city = cityList[position]
        cityViewHolder.setData(city,position)
    }

    override fun getItemCount(): Int {
        return cityList.size
    }
}