package com.example.weatherproject.addcity.dialogaddcity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.weatherproject.R
import com.example.weatherproject.addcity.dialogaddcity.item.AddCityItemDialog
import com.example.weatherproject.addcity.dialogaddcity.model.AddCityDataDialog
import com.example.weatherproject.databinding.FragmentDialogAddCityBinding
import com.mikepenz.fastadapter.GenericFastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.mikepenz.fastadapter.diff.FastAdapterDiffUtil

class DialogAddCityFragment : DialogFragment() {

    private var _binding: FragmentDialogAddCityBinding? = null
    private val binding get() = _binding!!

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
        with(binding.recyclerViewAddCityDialog) {
            adapter = fastAdapter
            itemAnimator = null
        }
        FastAdapterDiffUtil[addCityItemDialogAdapter] = testAddCityDataDialog
        binding.btnCancelAddCityDialog.setOnClickListener {
            dismiss()
        }
    }

    override fun getTheme(): Int = R.style.RoundedCornersDialog
}

private val testAddCityDataDialog = listOf(
    AddCityItemDialog(AddCityDataDialog("Москва")),
    AddCityItemDialog(AddCityDataDialog("Санкт-Петербург")),
    AddCityItemDialog(AddCityDataDialog("Тамбов")),
    AddCityItemDialog(AddCityDataDialog("Воронеж"))
)