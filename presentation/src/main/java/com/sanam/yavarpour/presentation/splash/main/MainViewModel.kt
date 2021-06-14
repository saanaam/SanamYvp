package com.sanam.yavarpour.presentation.splash.main

import androidx.lifecycle.SavedStateHandle
import com.sanam.yavarpour.common.AbstractViewModel
import com.sanam.yavarpour.common.state.ErrorState
import com.sanam.yavarpour.domain.usecase.appVersion.usecase.MusicListUseCase
import com.sanam.yavarpour.presentation.splash.main.model.AppVersionPresentationMapper
import com.sanam.yavarpour.presentation.splash.main.model.MusicListModel
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
            onSuccess = { it->
                this.onSuccess
                //TODO change the data type
                val data = ArrayList<MusicListModel>()
                for (item in it.data) {
                    appVersionPresentationMapper.toPresentation(item)
                   data.add(appVersionPresentationMapper.toPresentation(item))
                }
                _viewState.postValue(
                    MainState(data = data)
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