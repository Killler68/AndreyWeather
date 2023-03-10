package com.example.weatherproject.addcity.addcitydialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.example.weatherproject.R
import com.example.weatherproject.addcity.addcitydialog.item.AddCityItemDialog
import com.example.weatherproject.addcity.addcitydialog.viewmodel.AddCityDialogViewModel
import com.example.weatherproject.common.fragment.getViewModelFactory
import com.example.weatherproject.common.models.CityDialogData
import com.example.weatherproject.databinding.FragmentDialogAddCityBinding
import com.mikepenz.fastadapter.GenericFastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.mikepenz.fastadapter.diff.FastAdapterDiffUtil

class AddCityDialogFragment : DialogFragment() {

    private var _binding: FragmentDialogAddCityBinding? = null
    private val binding get() = _binding!!

    private val viewModel: AddCityDialogViewModel by viewModels { getViewModelFactory() }

    private val addCityItemDialogAdapter = ItemAdapter<AddCityItemDialog>()
    private val fastAdapter = GenericFastAdapter.with(listOf(addCityItemDialogAdapter))

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentDialogAddCityBinding.inflate(inflater, container, false)
        .also { _binding = it }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObservables()
        setupListeners()
        setupFastAdapter()
        viewModel.loadAddCityDialog()
    }

    private fun setupObservables() {
        viewModel.addCity.observe(viewLifecycleOwner, ::onDataLoaded)
    }

    private fun setupListeners() {
        binding.btnCancelAddCityDialog.setOnClickListener {
            dismiss()
        }
    }

    private fun onDataLoaded(addCityData: List<CityDialogData>) {
        FastAdapterDiffUtil[addCityItemDialogAdapter] = addCityData.map {
            AddCityItemDialog(it)
        }
    }

    override fun getTheme(): Int = R.style.RoundedCornersDialog

    private fun setupFastAdapter() {
        with(binding.recyclerViewAddCityDialog) {
            adapter = fastAdapter
            itemAnimator = null
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}