package com.example.weatherproject.addcity.usecase

import com.example.weatherproject.common.navigation.NavCommand

interface AddCityRouter {

    fun toAddCityDialog(): NavCommand
    fun toMainWeather(): NavCommand
}