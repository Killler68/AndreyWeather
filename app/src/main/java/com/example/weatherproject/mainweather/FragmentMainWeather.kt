package com.example.weatherproject.mainweather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.weatherproject.R
import com.example.weatherproject.common.context.toast
import com.example.weatherproject.common.extensions.TIME_FORMAT
import com.example.weatherproject.common.extensions.dateFormatPreview
import com.example.weatherproject.common.extensions.imageWeather
import com.example.weatherproject.common.fragment.getViewModelFactory
import com.example.weatherproject.common.navigation.NavCommand
import com.example.weatherproject.databinding.FragmentMainWeatherBinding
import com.example.weatherproject.mainweather.item.WeatherItem
import com.example.weatherproject.mainweather.model.WeatherData
import com.example.weatherproject.mainweather.model.WeatherPreviewData
import com.example.weatherproject.mainweather.viewmodel.MainWeatherViewModel
import com.mikepenz.fastadapter.GenericFastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.mikepenz.fastadapter.diff.FastAdapterDiffUtil


class FragmentMainWeather : Fragment() {

    private var _binding: FragmentMainWeatherBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainWeatherViewModel by viewModels { getViewModelFactory() }

    private val weatherItemAdapter = ItemAdapter<WeatherItem>()
    private val fastAdapter = GenericFastAdapter.with(listOf(weatherItemAdapter))

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentMainWeatherBinding.inflate(inflater, container, false)
        .also { _binding = it }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding.recyclerViewWeather) {
            adapter = fastAdapter
            itemAnimator = null
        }
        setupObservables()
        setupListeners()
    }

    private fun setupObservables() {
        with(viewModel) {
            weatherWeek.observe(viewLifecycleOwner, ::onDataLoaded)
            loadWeatherWeekAndOverTime()
            weatherPreview.observe(viewLifecycleOwner, ::onDataLoadedPreview)
            loadWeatherPreview()
            internetError.observe(viewLifecycleOwner) { toast(it) }
            navCommand.observe(viewLifecycleOwner, ::onDataLoadedNavigate)
        }
    }

    private fun onDataLoaded(weatherData: List<WeatherData>) {
        FastAdapterDiffUtil[weatherItemAdapter] = weatherData.map { WeatherItem(it) }
    }

    private fun onDataLoadedPreview(weatherPreviewData: List<WeatherPreviewData>) {
        val dtTimes = weatherPreviewData.first().dt.times(TIME_FORMAT)
        binding.apply {
            textPreviewWeather.text = dtTimes.dateFormatPreview()
            textFeelingTempPreview.text = weatherPreviewData.first().description
            textTempPreview.text = requireContext().resources.getString(
                R.string.temp, weatherPreviewData.first().temp.toInt().toString()
            )
        }
        Glide
            .with(requireView())
            .load(weatherPreviewData.first().icon.imageWeather())
            .into(binding.imageWeatherPreview)
    }

    private fun onDataLoadedNavigate(navCommand: NavCommand) {
        findNavController().navigate(navCommand.action, navCommand.command)
    }

    private fun setupListeners() {
        binding.btnGeolocation.setOnClickListener {
            viewModel.toAddCity()
        }
        binding.btnSearch.setOnClickListener {
            viewModel.toChangeCity()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

