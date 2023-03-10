package com.example.weatherproject.mainweather.viewmodel

import com.example.weatherproject.mainweather.model.WeatherData
import io.reactivex.Single

interface GetWeatherDataUseCase {

    operator fun invoke(): Single<List<WeatherData>>
}