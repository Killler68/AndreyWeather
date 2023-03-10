package com.example.weatherproject.addcity.addcitydialog.repository

import com.example.weatherproject.addcity.addcitydialog.usecase.AddCityDialogRepository
import com.example.weatherproject.common.models.CityDialogData

class AddCityDialogRepositoryImpl : AddCityDialogRepository {

    override fun getAddCity(): List<CityDialogData> = testCityDialogData
}

private val testCityDialogData = listOf(
    CityDialogData("Москва"),
    CityDialogData("Санкт-Петербург"),
    CityDialogData("Тамбов"),
    CityDialogData("Воронеж")
)