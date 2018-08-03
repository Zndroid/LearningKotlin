package com.hakz.learningkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.google.gson.Gson
import com.hakz.learningkotlin.domain.RequestForecastCommand
import org.jetbrains.anko.custom.async
import org.jetbrains.anko.find
import org.jetbrains.anko.uiThread
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val forecastList = find<RecyclerView>(R.id.forecast_list)
        forecastList.layoutManager = LinearLayoutManager(this)
        async() {
            val result = RequestForecastCommand("94043").execute()
                uiThread{
                forecastList.adapter = ForecastListAdapter(result)
            }
        }
    }

}


