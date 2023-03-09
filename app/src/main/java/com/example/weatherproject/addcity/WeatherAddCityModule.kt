package com.example.weatherproject.addcity

import androidx.lifecycle.ViewModel
import com.example.weatherproject.addcity.repository.WeatherAddCityRepository
import com.example.weatherproject.addcity.repository.WeatherAddCityRepositoryImpl
import com.example.weatherproject.addcity.router.AddCityRouterImpl
import com.example.weatherproject.addcity.usecase.AddCityDialogNavigatorUseCaseImpl
import com.example.weatherproject.addcity.usecase.AddCityRouter
import com.example.weatherproject.addcity.usecase.GetWeatherAddCityUseCase
import com.example.weatherproject.addcity.usecase.MainWeatherNavigatorUseCaseImpl
import com.example.weatherproject.addcity.viewmodel.AddCityDialogNavigatorUseCase
import com.example.weatherproject.addcity.viewmodel.MainWeatherNavigatorUseCase
import com.example.weatherproject.addcity.viewmodel.WeatherAddCityViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
class WeatherAddCityModule {

    @Provides
    fun provideRepositoryWeatherAddCity(): WeatherAddCityRepository = WeatherAddCityRepositoryImpl()

    @Provides
    fun provideUseCaseAddCity(weatherAddCityRepository: WeatherAddCityRepository):
            GetWeatherAddCityUseCase = GetWeatherAddCityUseCase(weatherAddCityRepository)

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
    @ClassKey(WeatherAddCityViewModel::class)
    fun getViewModelWeatherAddCity(
        getWeatherAddCityUseCase: GetWeatherAddCityUseCase,
        navigateToAddCityDialogUseCase: AddCityDialogNavigatorUseCase,
        navigateToMainWeatherUseCase: MainWeatherNavigatorUseCase
    ): ViewModel {
        return WeatherAddCityViewModel(
            getWeatherAddCityUseCase,
            navigateToAddCityDialogUseCase,
            navigateToMainWeatherUseCase
        )
    }
}