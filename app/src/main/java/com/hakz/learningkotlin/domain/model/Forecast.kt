package com.hakz.learningkotlin.domain.model

/**
 * Created by Administrator on 2018/8/3.
 */

data class Forecast(val id: Long, val date: Long, val description: String, val high: Int, val low: Int,
                    val iconUrl: String)