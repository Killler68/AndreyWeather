package com.example.weatherproject.mainweather.changecity.usecase

import com.example.weatherproject.addcity.dialogaddcity.model.AddCityDataDialog

interface ChangeCityDialogRepository {

    fun getChangeCity(): List<AddCityDataDialog>
}