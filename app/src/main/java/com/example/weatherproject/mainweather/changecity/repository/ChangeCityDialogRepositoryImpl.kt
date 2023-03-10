package com.example.weatherproject.mainweather.changecity.repository

import com.example.weatherproject.addcity.dialogaddcity.model.AddCityDataDialog
import com.example.weatherproject.mainweather.changecity.usecase.ChangeCityDialogRepository

class ChangeCityDialogRepositoryImpl : ChangeCityDialogRepository {

    override fun getChangeCity(): List<AddCityDataDialog> = testAddCityDataDialog
}

private val testAddCityDataDialog = listOf(
    AddCityDataDialog("Москва"),
    AddCityDataDialog("Санкт-Петербург"),
    AddCityDataDialog("Тамбов"),
    AddCityDataDialog("Воронеж")
)