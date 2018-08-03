package com.hakz.learningkotlin.domain

import com.google.gson.Gson
import com.hakz.learningkotlin.ForecastResult

/**
 * Created by Administrator on 2018/8/3.
 */

public interface Command<T> {
    fun execute(): T
}

public class ForecastRequest(val zipCode: String) {
    companion object {
        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private val URL = "http://api.openweathermap.org/data/2.5/" +
                "forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "$URL&APPID=$APP_ID&q="
    }

    fun execute(): ForecastResult {
        val forecastJsonStr = java.net.URL(COMPLETE_URL + zipCode).readText()
        return Gson().fromJson(forecastJsonStr, ForecastResult::
        class.java)
    }
}

class RequestForecastCommand(val zipCode: String) :
        Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(
                forecastRequest.execute())
    }
}