package com.example.weatherproject.addcity

import androidx.lifecycle.ViewModel
import com.example.weatherproject.addcity.usecase.WeatherAddCityRepository
import com.example.weatherproject.addcity.repository.WeatherAddCityRepositoryImpl
import com.example.weatherproject.addcity.router.AddCityRouterImpl
import com.example.weatherproject.addcity.usecase.AddCityDialogNavigatorUseCaseImpl
import com.example.weatherproject.addcity.usecase.AddCityRouter
import com.example.weatherproject.addcity.usecase.GetWeatherAddCityUseCaseImpl
import com.example.weatherproject.addcity.usecase.MainWeatherNavigatorUseCaseImpl
import com.example.weatherproject.addcity.viewmodel.AddCityDialogNavigatorUseCase
import com.example.weatherproject.addcity.viewmodel.GetWeatherAddCityUseCase
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
            GetWeatherAddCityUseCaseImpl = GetWeatherAddCityUseCaseImpl(weatherAddCityRepository)

    @Provides
    fun provideGetWeatherAddCityUseCase(WeatherAddCityRepository: WeatherAddCityRepository): GetWeatherAddCityUseCase =
        GetWeatherAddCityUseCaseImpl(WeatherAddCityRepository)

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
        getWeatherAddCityUseCaseImpl: GetWeatherAddCityUseCase,
        navigateToAddCityDialogUseCase: AddCityDialogNavigatorUseCase,
        navigateToMainWeatherUseCase: MainWeatherNavigatorUseCase
    ): ViewModel {
        return WeatherAddCityViewModel(
            getWeatherAddCityUseCaseImpl,
            navigateToAddCityDialogUseCase,
            navigateToMainWeatherUseCase
        )
    }
}