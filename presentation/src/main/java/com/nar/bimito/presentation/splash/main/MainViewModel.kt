package com.nar.bimito.presentation.splash.main

import androidx.lifecycle.SavedStateHandle
import com.nar.bimito.common.AbstractViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : AbstractViewModel<MainState>(
    MainState()) {

}