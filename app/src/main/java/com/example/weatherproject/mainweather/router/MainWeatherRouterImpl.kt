package com.example.weatherproject.mainweather.router

import com.example.weatherproject.R
import com.example.weatherproject.common.navigation.NavCommand
import com.example.weatherproject.mainweather.usecase.MainWeatherRouter

class MainWeatherRouterImpl : MainWeatherRouter {

    override fun toAddCity(): NavCommand = NavCommand(
        R.id.main_weather_to_weather_add_city
    )

    override fun toChangeCityDialog(): NavCommand = NavCommand(
        R.id.main_weather_to_dialog_change_city
    )
}