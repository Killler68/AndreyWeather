package com.example.weatherproject.mainweather.changecity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.example.weatherproject.R
import com.example.weatherproject.addcity.dialogaddcity.model.AddCityDataDialog
import com.example.weatherproject.common.fragment.getViewModelFactory
import com.example.weatherproject.databinding.FragmentDialogWeatherChangeCityBinding
import com.example.weatherproject.mainweather.changecity.item.ChangeCityItemDialog
import com.example.weatherproject.mainweather.changecity.viewmodel.ChangeCityDialogViewModel
import com.mikepenz.fastadapter.GenericFastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.mikepenz.fastadapter.diff.FastAdapterDiffUtil

class ChangeCityDialogFragment : DialogFragment() {

    private var _binding: FragmentDialogWeatherChangeCityBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ChangeCityDialogViewModel by viewModels { getViewModelFactory() }

    private val dialogAddCityItemAdapter = ItemAdapter<ChangeCityItemDialog>()
    private val fastAdapter = GenericFastAdapter.with(listOf(dialogAddCityItemAdapter))

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentDialogWeatherChangeCityBinding.inflate(inflater, container, false)
        .also { _binding = it }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObservables()
        setupListeners()
        setupFastAdapter()
        viewModel.loadChangeCity()
    }

    private fun setupObservables() {
        viewModel.changeCity.observe(viewLifecycleOwner, ::onDataLoaded)
    }

    private fun setupListeners() {
        binding.btnCancelChangeCityDialog.setOnClickListener {
            dismiss()
        }
    }

    private fun onDataLoaded(addCityDataDialog: List<AddCityDataDialog>) {
        FastAdapterDiffUtil[dialogAddCityItemAdapter] = addCityDataDialog.map {
            ChangeCityItemDialog(it)
        }
    }

    override fun getTheme(): Int = R.style.RoundedCornersDialog

    private fun setupFastAdapter() {
        with(binding.recyclerViewChangeCityDialog) {
            adapter = fastAdapter
            itemAnimator = null
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
