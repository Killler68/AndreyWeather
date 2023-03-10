package com.example.weatherproject.addcity.addcitydialog.usecase

import com.example.weatherproject.common.models.CityDialogData

interface AddCityDialogRepository {

    fun getAddCity(): List<CityDialogData>
}