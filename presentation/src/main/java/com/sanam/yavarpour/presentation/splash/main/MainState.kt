package com.sanam.yavarpour.presentation.splash.main

import androidx.navigation.NavDirections
import com.sanam.yavarpour.common.state.ErrorState
import com.sanam.yavarpour.common.state.ViewState
import com.sanam.yavarpour.presentation.splash.main.model.MusicItemModel

data class MainState(
    var data: ArrayList<MusicItemModel>? = null,
    override val error: ErrorState? = null,
    override val navigation: NavDirections? = null
) : ViewState