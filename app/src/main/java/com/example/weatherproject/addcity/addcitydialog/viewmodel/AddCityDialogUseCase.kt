package com.example.weatherproject.addcity.addcitydialog.viewmodel

import com.example.weatherproject.common.models.CityDialogData

interface AddCityDialogUseCase {

    operator fun invoke(): List<CityDialogData>
}