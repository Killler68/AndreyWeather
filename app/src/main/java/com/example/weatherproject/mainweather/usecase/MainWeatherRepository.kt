package com.example.weatherproject.mainweather.usecase

import com.example.weatherproject.mainweather.model.WeatherOverTimeData
import io.reactivex.Single

interface MainWeatherRepository {

    fun getWeatherWeekAndOverTime(): Single<List<WeatherOverTimeData>>
    fun getLoadWeatherWeekAndOverTime(): Single<List<WeatherOverTimeData>>

}