package com.example.weatherproject.mainweather.viewmodel

import com.example.weatherproject.common.navigation.NavCommand

interface AddCityNavigatorUseCase {

    operator fun invoke(): NavCommand
}