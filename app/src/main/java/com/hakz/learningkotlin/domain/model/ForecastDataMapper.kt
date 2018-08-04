package com.hakz.learningkotlin.domain.model

import com.hakz.learningkotlin.domain.datasource.Forecast
import com.hakz.learningkotlin.domain.datasource.ForecastResult
import com.hakz.learningkotlin.domain.model.Forecast as ModelForecast

/**
 * Created by Administrator on 2018/8/3.
 */

public class ForecastDataMapper {
    fun convertFromDataModel(forecast: ForecastResult): ForecastList {
        return ForecastList(0,forecast.city.name, forecast.city.country,
                convertForecastListToDomain(forecast.list))
    }

    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        return list.map { convertForecastItemToDomain(it) }
    }

    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast {
        return ModelForecast(0,forecast.dt,
                forecast.weather[0].description, forecast.temp.max.toInt(),
                forecast.temp.min.toInt(), generateIconUrl(forecast.
                weather[0].icon))
    }

    private fun generateIconUrl(iconCode: String): String
            = "http://openweathermap.org/img/w/$iconCode.png"
}