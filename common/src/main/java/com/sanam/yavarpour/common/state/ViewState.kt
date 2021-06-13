package com.sanam.yavarpour.common.state

import androidx.navigation.NavDirections
import com.sanam.yavarpour.common.state.ErrorState

interface ViewState {
    val error: ErrorState?
    val navigation: NavDirections?
}