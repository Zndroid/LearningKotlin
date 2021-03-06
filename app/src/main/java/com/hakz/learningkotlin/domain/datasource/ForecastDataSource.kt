package com.hakz.learningkotlin.domain.datasource

import com.hakz.learningkotlin.domain.model.Forecast
import com.hakz.learningkotlin.domain.model.ForecastList

interface ForecastDataSource {

    fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList?

    fun requestDayForecast(id: Long): Forecast?

}