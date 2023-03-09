package com.example.weatherproject.mainweather.viewmodel

import com.example.weatherproject.common.navigation.NavCommand

interface ChangeCityDialogNavigatorUseCase {

    operator fun invoke(): NavCommand
}