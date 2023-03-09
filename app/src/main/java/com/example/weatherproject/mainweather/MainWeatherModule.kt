package com.example.weatherproject.mainweather

import androidx.lifecycle.ViewModel
import com.example.weatherproject.common.api.WeatherApi
import com.example.weatherproject.common.network.NetworkModule
import com.example.weatherproject.mainweather.repository.MainWeatherPreviewRepository
import com.example.weatherproject.mainweather.repository.MainWeatherRepository
import com.example.weatherproject.mainweather.repository.MainWeatherRepositoryImpl
import com.example.weatherproject.mainweather.router.MainWeatherRouterImpl
import com.example.weatherproject.mainweather.usecase.*
import com.example.weatherproject.mainweather.viewmodel.AddCityNavigatorUseCase
import com.example.weatherproject.mainweather.viewmodel.ChangeCityDialogNavigatorUseCase
import com.example.weatherproject.mainweather.viewmodel.MainWeatherViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Singleton


@Module(includes = [NetworkModule::class])
class MainWeatherModule {

    @Provides
    fun provideRepository(weatherApi: WeatherApi): MainWeatherRepository =
        MainWeatherRepositoryImpl(weatherApi)

    @Provides
    fun providePreviewRepository(weatherApi: WeatherApi): MainWeatherPreviewRepository =
        MainWeatherRepositoryImpl(weatherApi)

    @Provides
    @Singleton
    fun weatherEventBus() = BehaviorSubject.create<Int>()

    @Provides
    fun provideUseCase(mainWeatherRepository: MainWeatherRepository): GetWeatherDataUseCase =
        GetWeatherDataUseCaseImpl(mainWeatherRepository)

    @Provides
    fun providePreviewUseCase(mainWeatherPreviewRepository: MainWeatherPreviewRepository):
            GetWeatherPreviewDataUseCase =
        GetWeatherPreviewDataUseCaseImpl(mainWeatherPreviewRepository)

    @Provides
    fun provideMainWeatherRouter(): MainWeatherRouter = MainWeatherRouterImpl()

    @Provides
    fun provideChangeCityDialogNavigatorUseCase(router: MainWeatherRouter):
            ChangeCityDialogNavigatorUseCase =
        ChangeCityDialogNavigatorUseCaseImpl(router)

    @Provides
    fun provideAddCityNavigatorUseCase(router: MainWeatherRouter): AddCityNavigatorUseCase =
        AddCityNavigatorUseCaseImpl(router)

    @Provides
    @IntoMap
    @ClassKey(MainWeatherViewModel::class)
    fun getViewModelMainWeather(
        getWeatherDataUseCase: GetWeatherDataUseCase,
        getWeatherPreviewDataUseCase: GetWeatherPreviewDataUseCase,
        navigateToChangeCityDialogUseCase: ChangeCityDialogNavigatorUseCase,
        navigateToAddCityUseCase: AddCityNavigatorUseCase
    ): ViewModel {
        return MainWeatherViewModel(
            getWeatherDataUseCase,
            getWeatherPreviewDataUseCase,
            navigateToChangeCityDialogUseCase,
            navigateToAddCityUseCase
        )
    }
}