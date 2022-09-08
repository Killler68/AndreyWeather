package com.example.weatherproject.mainweather.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherproject.common.rx.plusAssign
import com.example.weatherproject.mainweather.model.WeatherData
import com.example.weatherproject.mainweather.usecase.GetWeatherDataUseCase
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.BehaviorSubject

class MainWeatherViewModel(
    private val getWeatherDataUseCase: GetWeatherDataUseCase,
    private val weatherEventBus: BehaviorSubject<Int>
) : ViewModel() {

    private val _resultWeatherWeek: MutableLiveData<List<WeatherData>> = MutableLiveData()
    val resultWeatherWeek: LiveData<List<WeatherData>> get() = _resultWeatherWeek

    private val _internetError: MutableLiveData<String> = MutableLiveData()
    val internetError: LiveData<String> get() = _internetError

    private val compositeDisposable = CompositeDisposable()

    fun loadWeatherWeekAndOverTime() {
        compositeDisposable += getWeatherDataUseCase.executeWeatherWeekAndOverTime()
            .subscribe({
                _resultWeatherWeek.postValue(it)
            }, {
                _internetError.postValue(it.message)
            })
    }
}



