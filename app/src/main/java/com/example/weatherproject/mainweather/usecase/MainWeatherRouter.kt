package com.example.weatherproject.mainweather.usecase

import com.example.weatherproject.common.navigation.NavCommand

interface MainWeatherRouter {

     fun toAddCity(): NavCommand
     fun toChangeCityDialog(): NavCommand
}