package com.hakz.learningkotlin

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.hakz.learningkotlin.domain.ForecastList

/**
 * Created by Administrator on 2018/8/2.
 */

class ForecastListAdapter(val weekForecast: ForecastList) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {
    override fun getItemCount(): Int = weekForecast.dailyForecast.size

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        with(weekForecast.dailyForecast[position]) {
            holder?.textView?.text = "$date - $description - $high/$low"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder? {
        return ViewHolder(TextView(parent?.context))
    }

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

}