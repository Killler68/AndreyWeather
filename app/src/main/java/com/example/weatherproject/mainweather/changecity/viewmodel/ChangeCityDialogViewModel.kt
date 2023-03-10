package com.example.weatherproject.mainweather.changecity.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherproject.common.models.CityDialogData

class ChangeCityDialogViewModel(
    private val getChangeCity: ChangeCityDialogUseCase
) : ViewModel() {

    private val _changeCity: MutableLiveData<List<CityDialogData>> = MutableLiveData()
    val changeCity: LiveData<List<CityDialogData>> get() = _changeCity

    fun loadChangeCity() = _changeCity.postValue(getChangeCity())
}