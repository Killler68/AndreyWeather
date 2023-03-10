package com.example.weatherproject.addcity.repository

import com.example.weatherproject.addcity.model.AddCityData
import com.example.weatherproject.addcity.usecase.AddCityRepository

class AddCityRepositoryImpl : AddCityRepository {

    override fun getAddCity(): List<AddCityData> = testAddCity
}

private val testAddCity = listOf(
    AddCityData("Москва", "25°", "25°"),
    AddCityData("Санкт-Петербург", "25°", "25°"),
    AddCityData("Тамбов", "25 С", "25 С"),
    AddCityData("Воронеж", "25 С", "25 С"),
    AddCityData("Воронеж", "25 С", "25 С"),
    AddCityData("Воронеж", "25 С", "25 С"),
    AddCityData("Воронеж", "25 С", "25 С"),
    AddCityData("Воронеж", "25 С", "25 С"),
    AddCityData("Воронеж", "25 С", "25 С"),
    AddCityData("Воронеж", "25 С", "25 С"),
    AddCityData("Воронеж", "25 С", "25 С"),
    AddCityData("Воронеж", "25 С", "25 С"),
    AddCityData("Воронеж", "25 С", "25 С"),
    AddCityData("Воронеж", "25 С", "25 С"),
    AddCityData("Воронеж", "25 С", "25 С"),
    AddCityData("Воронеж", "25 С", "25 С"),
    AddCityData("Воронеж", "25 С", "25 С"),
    AddCityData("Воронеж", "25 С", "25 С"),
    AddCityData("Липецк", "25 С", "25 С")
)