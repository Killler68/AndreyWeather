package com.example.weatherproject.addcity.usecase

import com.example.weatherproject.addcity.model.AddCityData

interface AddCityRepository {

    fun getAddCity(): List<AddCityData>
}