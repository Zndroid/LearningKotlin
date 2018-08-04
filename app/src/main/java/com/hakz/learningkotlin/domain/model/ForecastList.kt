package com.hakz.learningkotlin.domain.model

/**
 * Created by Administrator on 2018/8/3.
 */

data class ForecastList(val id: Long,val city: String, val country: String,
                        val dailyForecast: List<Forecast>) {
    operator fun get(p: Int) = dailyForecast[p]
    fun size() = dailyForecast.size
}