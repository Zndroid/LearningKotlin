package com.hakz.learningkotlin.domain.commands

import com.hakz.learningkotlin.domain.datasource.ForecastProvider
import com.hakz.learningkotlin.domain.model.ForecastList

class RequestForecastCommand(
        private val zipCode: Long,
        private val forecastProvider: ForecastProvider = ForecastProvider()) :
        Command<ForecastList> {

    companion object {
        const val DAYS = 7
    }

    override fun execute() = forecastProvider.requestByZipCode(zipCode, DAYS)
}