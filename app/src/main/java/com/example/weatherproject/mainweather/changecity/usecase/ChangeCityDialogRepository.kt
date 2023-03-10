package com.example.weatherproject.mainweather.changecity.usecase

import com.example.weatherproject.common.models.CityDialogData

interface ChangeCityDialogRepository {

    fun getChangeCity(): List<CityDialogData>
}