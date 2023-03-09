package com.example.weatherproject.addcity.usecase

import com.example.weatherproject.addcity.viewmodel.AddCityDialogNavigatorUseCase
import com.example.weatherproject.common.navigation.NavCommand

class AddCityDialogNavigatorUseCaseImpl(
    private val router: AddCityRouter
) : AddCityDialogNavigatorUseCase {

    override fun invoke(): NavCommand = router.toAddCityDialog()
}