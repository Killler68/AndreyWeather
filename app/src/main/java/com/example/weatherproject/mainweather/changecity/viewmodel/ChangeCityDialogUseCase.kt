package com.example.weatherproject.mainweather.changecity.viewmodel

import com.example.weatherproject.addcity.dialogaddcity.model.AddCityDataDialog

interface ChangeCityDialogUseCase {

    operator fun invoke(): List<AddCityDataDialog>
}