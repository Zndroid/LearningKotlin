package com.hakz.learningkotlin.domain

/**
 * Created by Administrator on 2018/8/3.
 */

data class Forecast(val date: String, val description: String, val high: Int,
                    val low: Int)