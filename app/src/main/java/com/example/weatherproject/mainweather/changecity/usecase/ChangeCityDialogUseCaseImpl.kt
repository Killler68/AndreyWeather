package com.example.weatherproject.mainweather.changecity.usecase

import com.example.weatherproject.addcity.dialogaddcity.model.AddCityDataDialog
import com.example.weatherproject.mainweather.changecity.viewmodel.ChangeCityDialogUseCase

class ChangeCityDialogUseCaseImpl(
    private val repository: ChangeCityDialogRepository
) : ChangeCityDialogUseCase {

    override fun invoke(): List<AddCityDataDialog> = repository.getChangeCity()
}