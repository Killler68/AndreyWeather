package com.example.weatherproject.mainweather.changecity.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherproject.addcity.dialogaddcity.model.AddCityDataDialog

class ChangeCityDialogViewModel(
    private val getChangeCity: ChangeCityDialogUseCase
) : ViewModel() {

    private val _changeCity: MutableLiveData<List<AddCityDataDialog>> = MutableLiveData()
    val changeCity: LiveData<List<AddCityDataDialog>> get() = _changeCity

    fun loadChangeCity() = _changeCity.postValue(getChangeCity())
}