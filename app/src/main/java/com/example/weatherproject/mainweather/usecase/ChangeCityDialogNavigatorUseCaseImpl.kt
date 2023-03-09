package com.example.weatherproject.mainweather.usecase

import com.example.weatherproject.common.navigation.NavCommand
import com.example.weatherproject.mainweather.viewmodel.ChangeCityDialogNavigatorUseCase

class ChangeCityDialogNavigatorUseCaseImpl(
    private val router: MainWeatherRouter
) : ChangeCityDialogNavigatorUseCase {

    override fun invoke(): NavCommand = router.toChangeCityDialog()
}