package com.example.weatherproject.mainweather.usecase

import com.example.weatherproject.common.extensions.dateFormatUnixTimePreview
import com.example.weatherproject.mainweather.model.WeatherPreviewData
import com.example.weatherproject.mainweather.model.toWeatherPreviewData
import com.example.weatherproject.mainweather.viewmodel.GetWeatherPreviewUseCase
import io.reactivex.Single

class GetWeatherPreviewUseCaseImpl(
    private val mainWeatherPreviewRepository: MainWeatherPreviewRepository
) : GetWeatherPreviewUseCase {

    private val weatherPreview = mutableMapOf<String, MutableList<WeatherPreviewData>>()

    override operator fun invoke(): Single<List<WeatherPreviewData>> {
        return mainWeatherPreviewRepository.getLoadWeatherPreview().map {
            it.forEach {
                if (weatherPreview[it.dt.dateFormatUnixTimePreview()] != null)
                    weatherPreview[it.dt.dateFormatUnixTimePreview()]?.add(it)
                else weatherPreview[it.dt.dateFormatUnixTimePreview()] = mutableListOf()
            }
            weatherPreview.toWeatherPreviewData()
        }
    }
}