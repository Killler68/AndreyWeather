package com.example.weatherproject.addcity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.weatherproject.addcity.item.AddCityItem
import com.example.weatherproject.addcity.model.AddCityData
import com.example.weatherproject.addcity.viewmodel.AddCityViewModel
import com.example.weatherproject.common.fragment.getViewModelFactory
import com.example.weatherproject.common.navigation.NavCommand
import com.example.weatherproject.databinding.FragmentWeatherAddCityBinding
import com.mikepenz.fastadapter.GenericFastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.mikepenz.fastadapter.diff.FastAdapterDiffUtil


class AddCityFragment : Fragment() {

    private var _binding: FragmentWeatherAddCityBinding? = null
    private val binding get() = _binding!!

    private val viewModel: AddCityViewModel by viewModels { getViewModelFactory() }

    private val addCityItemAdapter = ItemAdapter<AddCityItem>()
    private val fastAdapter = GenericFastAdapter.with(listOf(addCityItemAdapter))

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentWeatherAddCityBinding.inflate(inflater, container, false)
        .also { _binding = it }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObservables()
        setupListeners()
        setupFastAdapter()
        viewModel.loadWeatherAddCity()
    }

    private fun setupObservables() {
        viewModel.resultWeatherAddCity.observe(viewLifecycleOwner, ::onDataLoaded)
        viewModel.navCommand.observe(viewLifecycleOwner, ::onDataLoadedNavigate)
    }

    private fun setupListeners() {
        binding.btnBackAddCity.setOnClickListener {
            viewModel.toMainWeather()
        }
        binding.btnAddCity.setOnClickListener {
            viewModel.toAddCityDialog()
        }
    }

    private fun onDataLoaded(addCityData: List<AddCityData>) {
        FastAdapterDiffUtil[addCityItemAdapter] = addCityData.map {
            AddCityItem(it)
        }
    }

    private fun onDataLoadedNavigate(navCommand: NavCommand) {
        findNavController().navigate(navCommand.action, navCommand.command)
    }

    private fun setupFastAdapter() {
        with(binding.recyclerViewAddCity) {
            adapter = fastAdapter
            itemAnimator = null
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
