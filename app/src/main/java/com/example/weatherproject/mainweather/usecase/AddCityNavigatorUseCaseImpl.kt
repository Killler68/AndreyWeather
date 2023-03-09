package com.example.weatherproject.mainweather.usecase

import com.example.weatherproject.common.navigation.NavCommand
import com.example.weatherproject.mainweather.viewmodel.AddCityNavigatorUseCase

class AddCityNavigatorUseCaseImpl(
    private val router: MainWeatherRouter
) : AddCityNavigatorUseCase {

    override fun invoke(): NavCommand = router.toAddCity()
}