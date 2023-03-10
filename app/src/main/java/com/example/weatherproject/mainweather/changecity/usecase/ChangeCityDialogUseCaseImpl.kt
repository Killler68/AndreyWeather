package com.example.weatherproject.mainweather.changecity.usecase

import com.example.weatherproject.common.models.CityDialogData
import com.example.weatherproject.mainweather.changecity.viewmodel.ChangeCityDialogUseCase

class ChangeCityDialogUseCaseImpl(
    private val repository: ChangeCityDialogRepository
) : ChangeCityDialogUseCase {

    override fun invoke(): List<CityDialogData> = repository.getChangeCity()
}