package com.nar.bimito.presentation.splash.main

import androidx.navigation.NavDirections
import com.nar.bimito.common.state.ErrorState
import com.nar.bimito.common.state.ViewState

data class MainState(override val error: ErrorState? = null,
                      override val navigation: NavDirections? = null): ViewState