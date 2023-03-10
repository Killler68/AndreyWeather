package com.example.weatherproject.addcity

import androidx.lifecycle.ViewModel
import com.example.weatherproject.addcity.usecase.AddCityRepository
import com.example.weatherproject.addcity.repository.AddCityRepositoryImpl
import com.example.weatherproject.addcity.router.AddCityRouterImpl
import com.example.weatherproject.addcity.usecase.AddCityDialogNavigatorUseCaseImpl
import com.example.weatherproject.addcity.usecase.AddCityRouter
import com.example.weatherproject.addcity.usecase.GetAddCityUseCaseImpl
import com.example.weatherproject.addcity.usecase.MainWeatherNavigatorUseCaseImpl
import com.example.weatherproject.addcity.viewmodel.AddCityDialogNavigatorUseCase
import com.example.weatherproject.addcity.viewmodel.GetAddCityUseCase
import com.example.weatherproject.addcity.viewmodel.MainWeatherNavigatorUseCase
import com.example.weatherproject.addcity.viewmodel.AddCityViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
class AddCityModule {

    @Provides
    fun provideRepositoryWeatherAddCity(): AddCityRepository = AddCityRepositoryImpl()

    @Provides
    fun provideGetAddCityUseCase(AddCityRepository: AddCityRepository): GetAddCityUseCase =
        GetAddCityUseCaseImpl(AddCityRepository)

    @Provides
    fun provideAddCityRouter(): AddCityRouter = AddCityRouterImpl()

    @Provides
    fun provideAddCityDialogNavigatorUseCase(router: AddCityRouter):
            AddCityDialogNavigatorUseCase =
        AddCityDialogNavigatorUseCaseImpl(router)

    @Provides
    fun provideMainWeatherNavigatorUseCase(router: AddCityRouter): MainWeatherNavigatorUseCase =
        MainWeatherNavigatorUseCaseImpl(router)

    @Provides
    @IntoMap
    @ClassKey(AddCityViewModel::class)
    fun getViewModelWeatherAddCity(
        getAddCityUseCaseImpl: GetAddCityUseCase,
        navigateToAddCityDialogUseCase: AddCityDialogNavigatorUseCase,
        navigateToMainWeatherUseCase: MainWeatherNavigatorUseCase
    ): ViewModel {
        return AddCityViewModel(
            getAddCityUseCaseImpl,
            navigateToAddCityDialogUseCase,
            navigateToMainWeatherUseCase
        )
    }
}