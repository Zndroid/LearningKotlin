package com.hakz.learningkotlin.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hakz.learningkotlin.R
import com.hakz.learningkotlin.domain.model.Forecast
import com.hakz.learningkotlin.domain.model.ForecastList
import com.hakz.learningkotlin.extensions.ctx
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_forecast.view.*
import java.text.DateFormat
import java.util.*

/**
 * Created by Administrator on 2018/8/2.
 */

class ForecastListAdapter(val weekForecast: ForecastList, val itemClick: (Forecast) -> Unit) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindForecast(weekForecast[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder? {
        val view = LayoutInflater.from(parent?.ctx).inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun getItemCount(): Int = weekForecast.size()

    class ViewHolder(view: View, val itemClick: (Forecast) -> Unit) : RecyclerView.ViewHolder(view) {


        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.get().load(iconUrl).placeholder(R.mipmap.ic_launcher).into(itemView.icon)
                itemView.date.text = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault()).format(date*1000)
                itemView.description.text = description
                itemView.maxTemperature.text = "${high}°"
                itemView.minTemperature.text = "${low}°"
                itemView.setOnClickListener { itemClick(forecast) }
            }
        }
    }

}

