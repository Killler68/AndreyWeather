package com.example.weatherproject.mainweather.changecity.repository

import com.example.weatherproject.common.models.CityDialogData
import com.example.weatherproject.mainweather.changecity.usecase.ChangeCityDialogRepository

class ChangeCityDialogRepositoryImpl : ChangeCityDialogRepository {

    override fun getChangeCity(): List<CityDialogData> = testCityDialogData
}

private val testCityDialogData = listOf(
    CityDialogData("Москва"),
    CityDialogData("Санкт-Петербург"),
    CityDialogData("Тамбов"),
    CityDialogData("Воронеж")
)