package com.example.weatherproject.addcity.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherproject.addcity.model.WeatherAddCityData
import com.example.weatherproject.common.navigation.NavCommand

class WeatherAddCityViewModel(
    private val getWeatherAddCityUseCase: GetWeatherAddCityUseCase,
    private val navigateToAddCityDialog: AddCityDialogNavigatorUseCase,
    private val navigateToMainWeather: MainWeatherNavigatorUseCase
) : ViewModel() {

    private val _resultWeatherAddCity: MutableLiveData<List<WeatherAddCityData>> = MutableLiveData()
    val resultWeatherAddCity: LiveData<List<WeatherAddCityData>> = _resultWeatherAddCity

    private val _navCommand: MutableLiveData<NavCommand> = MutableLiveData()
    val navCommand: LiveData<NavCommand> get() = _navCommand

    fun loadWeatherAddCity() =
        _resultWeatherAddCity.postValue(getWeatherAddCityUseCase())

    fun toAddCityDialog() {
        _navCommand.postValue(navigateToAddCityDialog())
    }

    fun toMainWeather() {
        _navCommand.postValue(navigateToMainWeather())
    }
}