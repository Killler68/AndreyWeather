package com.example.weatherproject.common.api

import com.example.weatherproject.mainweather.model.WeatherDataApi
import com.example.weatherproject.mainweather.model.WeatherPreviewData
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


const val BASE_URL = "https://api.openweathermap.org"
const val API_KEY =
    "/data/2.5/forecast?id=498817&units=metric&appid=1fb564b0448c20cff8c8a08d408dba5b&lang=ru"

interface WeatherApi {

    @GET(API_KEY)
    fun getWeatherWeekAndOverTime(): Single<List<WeatherDataApi>>

    @GET(API_KEY)
    fun getWeatherPreview(): Single<WeatherPreviewData>

    companion object {
        fun create(): WeatherApi {
            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(WeatherApi::class.java)
        }
    }
}