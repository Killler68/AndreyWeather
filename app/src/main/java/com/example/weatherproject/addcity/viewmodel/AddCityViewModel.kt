package com.example.weatherproject.addcity.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherproject.addcity.model.AddCityData
import com.example.weatherproject.common.navigation.NavCommand

class AddCityViewModel(
    private val getAddCityUseCase: GetAddCityUseCase,
    private val navigateToAddCityDialog: AddCityDialogNavigatorUseCase,
    private val navigateToMainWeather: MainWeatherNavigatorUseCase
) : ViewModel() {

    private val _resultWeatherAddCity: MutableLiveData<List<AddCityData>> = MutableLiveData()
    val resultWeatherAddCity: LiveData<List<AddCityData>> = _resultWeatherAddCity

    private val _navCommand: MutableLiveData<NavCommand> = MutableLiveData()
    val navCommand: LiveData<NavCommand> get() = _navCommand

    fun loadWeatherAddCity() =
        _resultWeatherAddCity.postValue(getAddCityUseCase())

    fun toAddCityDialog() {
        _navCommand.postValue(navigateToAddCityDialog())
    }

    fun toMainWeather() {
        _navCommand.postValue(navigateToMainWeather())
    }
}