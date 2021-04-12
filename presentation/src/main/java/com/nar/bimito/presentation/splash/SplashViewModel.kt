package com.nar.bimito.presentation.splash

import androidx.lifecycle.SavedStateHandle
import com.nar.bimito.common.AbstractViewModel
import dagger.assisted.Assisted
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(@Assisted private val savedStateHandle: SavedStateHandle) : AbstractViewModel<SplashState>(SplashState()) {




}