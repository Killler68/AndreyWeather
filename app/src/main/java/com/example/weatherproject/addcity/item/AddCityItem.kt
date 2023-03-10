package com.example.weatherproject.addcity.item

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.weatherproject.R
import com.example.weatherproject.addcity.model.AddCityData
import com.example.weatherproject.databinding.RecyclerItemWeatherAddCityBinding
import com.mikepenz.fastadapter.binding.AbstractBindingItem

class AddCityItem(private val addCityData: AddCityData) :
    AbstractBindingItem<RecyclerItemWeatherAddCityBinding>() {

    override fun bindView(binding: RecyclerItemWeatherAddCityBinding, payloads: List<Any>) {
        super.bindView(binding, payloads)

        binding.apply {
            textNameAddCity.text = addCityData.nameCity
            tempMaxAddCity.text = addCityData.tempMax
            tempMinAddCity.text = addCityData.tempMin
        }
    }

    override fun createBinding(
        inflater: LayoutInflater,
        parent: ViewGroup?
    ): RecyclerItemWeatherAddCityBinding =
        RecyclerItemWeatherAddCityBinding.inflate(inflater, parent, false)

    override val type: Int = R.id.background_main_weather_add_city
}