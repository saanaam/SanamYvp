package com.nar.bimito.presentation.splash

import androidx.navigation.NavDirections
import com.nar.bimito.common.Event
import com.nar.bimito.common.state.ErrorState
import com.nar.bimito.common.state.ViewState

data class SplashState(
    val navigateToLink: Event? = null,
    override val error: ErrorState? = null,
    override val navigation: NavDirections? = null
) : ViewState