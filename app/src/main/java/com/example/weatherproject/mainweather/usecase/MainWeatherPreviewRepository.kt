package com.example.weatherproject.mainweather.usecase

import com.example.weatherproject.mainweather.model.WeatherPreviewData
import io.reactivex.Single

interface MainWeatherPreviewRepository {

    fun getWeatherPreview(): Single<List<WeatherPreviewData>>
    fun getLoadWeatherPreview(): Single<List<WeatherPreviewData>>

}