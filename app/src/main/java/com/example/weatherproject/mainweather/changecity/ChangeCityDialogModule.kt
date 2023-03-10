package com.example.weatherproject.mainweather.changecity

import androidx.lifecycle.ViewModel
import com.example.weatherproject.mainweather.changecity.repository.ChangeCityDialogRepositoryImpl
import com.example.weatherproject.mainweather.changecity.usecase.ChangeCityDialogRepository
import com.example.weatherproject.mainweather.changecity.usecase.ChangeCityDialogUseCaseImpl
import com.example.weatherproject.mainweather.changecity.viewmodel.ChangeCityDialogUseCase
import com.example.weatherproject.mainweather.changecity.viewmodel.ChangeCityDialogViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
class ChangeCityDialogModule {

    @Provides
    fun provideChangeCityDialogRepository(): ChangeCityDialogRepository =
        ChangeCityDialogRepositoryImpl()

    @Provides
    fun provideChangeCityDialogUseCase(changeCityDialogRepository: ChangeCityDialogRepository):
            ChangeCityDialogUseCase = ChangeCityDialogUseCaseImpl(changeCityDialogRepository)

    @Provides
    @IntoMap
    @ClassKey(ChangeCityDialogViewModel::class)
    fun provideChangeCityDialogViewModel(
        getChangeCityDialogUseCase: ChangeCityDialogUseCase
    ): ViewModel = ChangeCityDialogViewModel(
        getChangeCityDialogUseCase
    )
}