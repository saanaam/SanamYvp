package com.nar.bimito.presentation.splash.main

import androidx.lifecycle.SavedStateHandle
import com.nar.bimito.common.AbstractViewModel
import com.nar.bimito.common.exception.PresentationExceptionDecorator
import com.nar.bimito.domain.usecase.appVersion.usecase.AppVersionUseCase
import com.nar.bimito.presentation.splash.main.model.AppVersionPresentationMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    mainExceptionDecorator: MainExceptionDecorator,
    private val appVersionPresentationMapper: AppVersionPresentationMapper,
    private val appVersionUseCase: AppVersionUseCase,
    private val savedStateHandle: SavedStateHandle
) : AbstractViewModel<MainState>(
    MainState()
) {

    override var exceptionFactoryDecorator: PresentationExceptionDecorator? =
        mainExceptionDecorator

    fun getAppVersion() {
        appVersionUseCase.perform() {
            onSuccess = {
                this.onSuccess
                _viewState.postValue(
                    MainState(data = appVersionPresentationMapper.toPresentation(it.data))
                )
            }
            onError = {
                this.onError
                _viewState.postValue(
                    MainState(error = exceptionFactoryDecorator?.create(it))
                )
            }
            onFinish = {
                this.onFinish
            }
        }
    }

}