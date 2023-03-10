package com.example.weatherproject.common.module

import com.example.weatherproject.addcity.AddCityModule
import com.example.weatherproject.common.application.ApplicationModule
import com.example.weatherproject.mainweather.MainWeatherModule
import dagger.Module


@Module(
    includes = [
        MainWeatherModule::class,
        AddCityModule::class,
        ApplicationModule::class
    ]
)
class FeaturesModule