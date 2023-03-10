package com.example.weatherproject.addcity.usecase

import com.example.weatherproject.addcity.model.AddCityData
import com.example.weatherproject.addcity.viewmodel.GetAddCityUseCase

class GetAddCityUseCaseImpl(
    private val repository: AddCityRepository
) : GetAddCityUseCase {

    override fun invoke(): List<AddCityData> = repository.getAddCity()
}