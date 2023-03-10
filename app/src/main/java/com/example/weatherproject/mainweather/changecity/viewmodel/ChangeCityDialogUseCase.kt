package com.example.weatherproject.mainweather.changecity.viewmodel

import com.example.weatherproject.common.models.CityDialogData

interface ChangeCityDialogUseCase {

    operator fun invoke(): List<CityDialogData>
}