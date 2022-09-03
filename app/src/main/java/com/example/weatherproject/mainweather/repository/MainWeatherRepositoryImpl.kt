package com.example.weatherproject.mainweather.repository

import android.annotation.SuppressLint
import com.example.weatherproject.common.api.WeatherApi
import com.example.weatherproject.mainweather.model.WeatherData
import com.example.weatherproject.mainweather.model.WeatherOverTimeData
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainWeatherRepositoryImpl(private val weatherApi: WeatherApi) : MainWeatherRepository {

    override fun getWeatherWeekAndOverTime(): Single<List<WeatherData>> {
        val response = weatherApi.getWeatherData()
        return response.map {
            it.map {
                WeatherData(
                    it.temp,
                    it.description,
                    it.temp_max,
                    it.dt_txt,
                    it.temp_min,

                    list = listOf(
                        WeatherOverTimeData(
                            dt_txt = it.toString(),
                            temp = it.toString()

                        )
                    )

                )
            }


        }

    }

    override fun getLoadWeatherWeekAndOverTime(): Single<List<WeatherData>> {
        return getWeatherWeekAndOverTime()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }


//    override fun getLoadWeatherPreview(): Single<WeatherPreviewData> {
//        return weatherApi.getWeatherPreview()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//    }
}
//
//private val testWeatherWeek by lazy {
//    listOf(
//        WeatherData("23 августа, ", "пт", "25° ", "28°", testWeatherOverTime),
//        WeatherData("24 августа, ", "сб", "26° ", "29°", testWeatherOverTime),
//        WeatherData("25 августа, ", "вс", "23° ", "25°", testWeatherOverTime),
//        WeatherData("26 августа, ", "пн", "23° ", "23°", testWeatherOverTime),
//        WeatherData("27 августа, ", "вт", "23° ", "23°", testWeatherOverTime),
//        WeatherData("28 августа, ", "ср", "23° ", "23°", testWeatherOverTime),
//        WeatherData("29 августа, ", "чт", "23° ", "23°", testWeatherOverTime),
//        WeatherData("30 августа, ", "пт", "23° ", "23°", testWeatherOverTime),
//
//        )
//}
//
//private val testWeatherOverTime = listOf(
//    WeatherOverTimeData("12:00", "25°"),
//    WeatherOverTimeData("14:00", "26°"),
//    WeatherOverTimeData("16:00", "27°"),
//    WeatherOverTimeData("18:00", "25°"),
//    WeatherOverTimeData("20:00", "24°"),
//    WeatherOverTimeData("22:00", "22°"),
//    WeatherOverTimeData("00:00", "20°"),
//)
//private val testWeatherPreview =
//    WeatherPreviewData(
//        "Сегодня, 22 августа, чт",
//        "24°",
//        "Ясно, ощущается, как 25° "
//
//    )
