package com.nar.bimito.presentation.splash.main

import androidx.navigation.NavDirections
import com.nar.bimito.common.state.ErrorState
import com.nar.bimito.common.state.ViewState
import com.nar.bimito.presentation.splash.main.model.AppVersionModel

data class MainState(
    var data: AppVersionModel? = null,
    override val error: ErrorState? = null,
     override val navigation: NavDirections? = null
) : ViewState