package com.example.weatherproject.mainweather.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherproject.common.navigation.NavCommand
import com.example.weatherproject.common.rx.plusAssign
import com.example.weatherproject.mainweather.model.WeatherData
import com.example.weatherproject.mainweather.model.WeatherPreviewData
import io.reactivex.disposables.CompositeDisposable

class MainWeatherViewModel(
    private val getWeatherDataUseCase: GetWeatherDataUseCase,
    private val getWeatherPreviewDataUseCase: GetWeatherPreviewDataUseCase,
    private val navigateToChangeCityDialog: ChangeCityDialogNavigatorUseCase,
    private val navigateToAddCity: AddCityNavigatorUseCase
) : ViewModel() {

    private val _resultWeatherWeek: MutableLiveData<List<WeatherData>> = MutableLiveData()
    val resultWeatherWeek: LiveData<List<WeatherData>> get() = _resultWeatherWeek

    private val _resultWeatherPreview: MutableLiveData<List<WeatherPreviewData>> = MutableLiveData()
    val resultWeatherPreview: LiveData<List<WeatherPreviewData>> get() = _resultWeatherPreview

    private val _internetError: MutableLiveData<String> = MutableLiveData()
    val internetError: LiveData<String> get() = _internetError

    private val _navCommand: MutableLiveData<NavCommand> = MutableLiveData()
    val navCommand: LiveData<NavCommand> get() = _navCommand

    private val compositeDisposable = CompositeDisposable()

    fun loadWeatherWeekAndOverTime() {
        compositeDisposable += getWeatherDataUseCase()
            .subscribe({
                _resultWeatherWeek.postValue(it)
            }, {
                _internetError.postValue(it.message)
            })
    }

    fun loadWeatherPreview() {
        compositeDisposable += getWeatherPreviewDataUseCase()
            .subscribe({
                _resultWeatherPreview.postValue(it)
            }, {
                _internetError.postValue(it.message)
            })
    }

    fun toChangeCity() = _navCommand.postValue(navigateToChangeCityDialog())

    fun toAddCity() = _navCommand.postValue(navigateToAddCity())

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}



