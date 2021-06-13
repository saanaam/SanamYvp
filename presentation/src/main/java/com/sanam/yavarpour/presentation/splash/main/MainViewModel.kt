package com.sanam.yavarpour.presentation.splash.main

import androidx.lifecycle.SavedStateHandle
import com.sanam.yavarpour.common.AbstractViewModel
import com.sanam.yavarpour.common.state.ErrorState
import com.sanam.yavarpour.domain.usecase.appVersion.usecase.MusicListUseCase
import com.sanam.yavarpour.presentation.splash.main.model.AppVersionPresentationMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val appVersionPresentationMapper: AppVersionPresentationMapper,
    private val appVersionUseCase: MusicListUseCase,
) : AbstractViewModel<MainState>(
    MainState()
) {

    fun getAppVersion() {
        appVersionUseCase.perform() {
            onSuccess = {
                this.onSuccess
                _viewState.postValue(
                    MainState(data = appVersionPresentationMapper.toPresentation(it.data[0]))
                )
            }
            onError = {
                this.onError
                _viewState.postValue(
                    MainState(error = ErrorState(it.message!!))
                )
            }
            onFinish = {
                this.onFinish
            }
        }
    }


    override fun clearViewModel() {
        super.clearViewModel()
        appVersionUseCase.dispose()
    }

}