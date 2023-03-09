package com.example.weatherproject.addcity.viewmodel

import com.example.weatherproject.common.navigation.NavCommand

interface AddCityDialogNavigatorUseCase {

    operator fun invoke(): NavCommand
}