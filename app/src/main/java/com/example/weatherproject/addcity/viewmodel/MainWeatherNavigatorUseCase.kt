package com.example.weatherproject.addcity.viewmodel

import com.example.weatherproject.common.navigation.NavCommand

interface MainWeatherNavigatorUseCase {

    operator fun invoke(): NavCommand
}