package com.example.weatherproject.addcity.usecase

import com.example.weatherproject.addcity.viewmodel.MainWeatherNavigatorUseCase
import com.example.weatherproject.common.navigation.NavCommand

class MainWeatherNavigatorUseCaseImpl(
    private val router: AddCityRouter
) : MainWeatherNavigatorUseCase {

    override fun invoke(): NavCommand = router.toMainWeather()
}