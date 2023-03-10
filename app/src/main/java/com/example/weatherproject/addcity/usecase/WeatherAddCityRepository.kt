package com.example.weatherproject.addcity.usecase

import com.example.weatherproject.addcity.model.WeatherAddCityData

interface WeatherAddCityRepository {

    fun getWeatherAddCity(): List<WeatherAddCityData>
}