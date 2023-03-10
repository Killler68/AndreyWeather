package com.example.weatherproject.addcity.addcitydialog.usecase

import com.example.weatherproject.addcity.addcitydialog.viewmodel.AddCityDialogUseCase
import com.example.weatherproject.common.models.CityDialogData

class AddCityDialogUseCaseImpl(
    private val repository: AddCityDialogRepository
) : AddCityDialogUseCase {

    override fun invoke(): List<CityDialogData> = repository.getAddCity()
}