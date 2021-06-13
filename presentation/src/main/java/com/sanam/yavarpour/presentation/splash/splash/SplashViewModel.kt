package com.sanam.yavarpour.presentation.splash.splash

import androidx.lifecycle.SavedStateHandle
import com.sanam.yavarpour.common.AbstractViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : AbstractViewModel<SplashState>(
    SplashState()
) {
    fun gotoMain() {
        _viewState.value = SplashState(navigation = SplashFragmentDirections.actionSplashToMain())
    }
}