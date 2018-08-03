package com.hakz.learningkotlin.domain

/**
 * Created by Administrator on 2018/8/3.
 */

data class ForecastList(val city: String, val country: String,
                        val dailyForecast: List<Forecast>) {
    operator fun get(p: Int) = dailyForecast[p]
    fun size() = dailyForecast.size
}