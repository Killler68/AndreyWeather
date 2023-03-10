package com.example.weatherproject.addcity.viewmodel

import com.example.weatherproject.addcity.model.WeatherAddCityData

interface GetWeatherAddCityUseCase {

    operator fun invoke(): List<WeatherAddCityData>
}