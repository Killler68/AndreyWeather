package com.example.weatherproject.mainweather.viewmodel

import com.example.weatherproject.mainweather.model.WeatherPreviewData
import io.reactivex.Single

interface GetWeatherPreviewUseCase {

    operator fun invoke(): Single<List<WeatherPreviewData>>

}