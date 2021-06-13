package com.sanam.yavarpour.presentation.splash.splash

import androidx.navigation.NavDirections
import com.sanam.yavarpour.common.Event
import com.sanam.yavarpour.common.state.ErrorState
import com.sanam.yavarpour.common.state.ViewState

data class SplashState(
    val navigateToLink: Event? = null,
    override val error: ErrorState? = null,
    override val navigation: NavDirections? = null
) : ViewState