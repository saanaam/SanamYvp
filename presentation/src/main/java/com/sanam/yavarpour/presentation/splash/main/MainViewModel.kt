package com.sanam.yavarpour.presentation.splash.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.sanam.yavarpour.common.AbstractViewModel
import com.sanam.yavarpour.common.state.ErrorState
import com.sanam.yavarpour.domain.usecase.musicPlayer.usecase.musicListUseCase.GetMusicListUseCase
import com.sanam.yavarpour.presentation.splash.main.model.MusicListPresentationMapper
import com.sanam.yavarpour.presentation.splash.main.model.MusicItemModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getMusicListUseCase: GetMusicListUseCase,
    private val musicListPresentationMapper: MusicListPresentationMapper,
) : AbstractViewModel<MainState>(
    MainState()
) {
    private val _isPlayData = MutableLiveData<Boolean>()
    val isPlayData: LiveData<Boolean> = _isPlayData
    private val _isPauseData = MutableLiveData<Boolean>()
    val isPauseData: LiveData<Boolean> = _isPauseData
    private val _playerData = MutableLiveData<Int>()
    val playerData: LiveData<Int> = _playerData

    init {
        _isPlayData.value = false
        _isPauseData.value = false
    }

    fun updateSong(musicPosition: Int) {
        _playerData.value = musicPosition
    }

    fun getMusicList() {
        getMusicListUseCase.perform() {
            onSuccess = { it ->
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
        getMusicListUseCase.dispose()
    }

    fun setPlayStatus(playStatus: Boolean) {
        _isPlayData.value = playStatus
    }

    fun setPauseStatus(pauseStatus: Boolean) {
        _isPauseData.value = pauseStatus
    }

}