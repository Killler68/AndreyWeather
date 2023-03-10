package com.example.weatherproject.addcity.usecase

import com.example.weatherproject.addcity.model.WeatherAddCityData
import com.example.weatherproject.addcity.viewmodel.GetWeatherAddCityUseCase

class GetWeatherAddCityUseCaseImpl(
    private val repository: WeatherAddCityRepository
) : GetWeatherAddCityUseCase {

    override fun invoke(): List<WeatherAddCityData> = repository.getWeatherAddCity()
}