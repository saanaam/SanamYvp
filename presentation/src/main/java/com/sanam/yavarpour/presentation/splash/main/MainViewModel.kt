package com.sanam.yavarpour.presentation.splash.main

import androidx.lifecycle.SavedStateHandle
import com.sanam.yavarpour.common.AbstractViewModel
import com.sanam.yavarpour.common.state.ErrorState
import com.sanam.yavarpour.domain.usecase.appVersion.usecase.MusicListUseCase
import com.sanam.yavarpour.presentation.splash.main.model.musicListPresentationMapper
import com.sanam.yavarpour.presentation.splash.main.model.MusicItemModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val musicListPresentationMapper: musicListPresentationMapper,
    private val musicListUseCase: MusicListUseCase,
) : AbstractViewModel<MainState>(
    MainState()
) {

    fun getMusicList() {
        musicListUseCase.perform() {
            onSuccess = { it->
                this.onSuccess
                val data = ArrayList<MusicItemModel>()
                for (item in it.data) {
                    musicListPresentationMapper.toPresentation(item)
                   data.add(musicListPresentationMapper.toPresentation(item))
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
        musicListUseCase.dispose()
    }

    fun setPlayStatus(b: Boolean) {

    }

}