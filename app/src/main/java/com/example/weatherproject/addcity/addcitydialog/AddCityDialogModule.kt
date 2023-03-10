package com.example.weatherproject.addcity.addcitydialog

import androidx.lifecycle.ViewModel
import com.example.weatherproject.addcity.addcitydialog.repository.AddCityDialogRepositoryImpl
import com.example.weatherproject.addcity.addcitydialog.usecase.AddCityDialogRepository
import com.example.weatherproject.addcity.addcitydialog.usecase.AddCityDialogUseCaseImpl
import com.example.weatherproject.addcity.addcitydialog.viewmodel.AddCityDialogUseCase
import com.example.weatherproject.addcity.addcitydialog.viewmodel.AddCityDialogViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
class AddCityDialogModule {

    @Provides
    fun provideAddCityDialogRepository(): AddCityDialogRepository = AddCityDialogRepositoryImpl()

    @Provides
    fun provideAddCityDialogUseCase(addCityDialogRepository: AddCityDialogRepository):
            AddCityDialogUseCase =
        AddCityDialogUseCaseImpl(addCityDialogRepository)

    @Provides
    @IntoMap
    @ClassKey(AddCityDialogViewModel::class)
    fun provideAddCityDialogViewModel(
        getAddCityDialogUseCase: AddCityDialogUseCase
    ): ViewModel = AddCityDialogViewModel(
        getAddCityDialogUseCase
    )
}