package com.example.weatherproject.addcity.addcitydialog.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherproject.common.models.CityDialogData

class AddCityDialogViewModel(
    private val getAddCityDialog: AddCityDialogUseCase
) : ViewModel() {

    private val _addCity: MutableLiveData<List<CityDialogData>> = MutableLiveData()
    val addCity: LiveData<List<CityDialogData>> get() = _addCity

    fun loadAddCityDialog() = _addCity.postValue(getAddCityDialog())
}