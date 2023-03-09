package com.example.weatherproject.addcity.router

import com.example.weatherproject.R
import com.example.weatherproject.addcity.usecase.AddCityRouter
import com.example.weatherproject.common.navigation.NavCommand

class AddCityRouterImpl : AddCityRouter {

    override fun toAddCityDialog(): NavCommand = NavCommand(
        R.id.weather_add_city_to_dialog_add_city
    )

    override fun toMainWeather(): NavCommand = NavCommand(
        R.id.weather_add_city_to_main_weather
    )
}