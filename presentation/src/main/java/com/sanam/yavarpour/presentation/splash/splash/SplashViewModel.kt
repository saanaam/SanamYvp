package com.sanam.yavarpour.presentation.splash.splash

import androidx.lifecycle.SavedStateHandle
import com.sanam.yavarpour.common.AbstractViewModel
import com.sanam.yavarpour.domain.usecase.musicPlayer.usecase.musicListUseCase.SetMusicListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val setMusicListUseCase: SetMusicListUseCase
) : AbstractViewModel<SplashState>(
    SplashState()
) {

    fun setMusicList(isPremium: Boolean) {
        setMusicListUseCase.perform(isPremium) {
            onSuccess = {
                _viewState.value =
                    SplashState(navigation = SplashFragmentDirections.actionSplashToMain())
            }
        }
    }

}