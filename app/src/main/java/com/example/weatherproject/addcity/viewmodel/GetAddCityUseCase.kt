package com.example.weatherproject.addcity.viewmodel

import com.example.weatherproject.addcity.model.AddCityData

interface GetAddCityUseCase {

    operator fun invoke(): List<AddCityData>
}