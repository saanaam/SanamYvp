package com.nar.bimito.common.state

import androidx.navigation.NavDirections
import com.nar.bimito.common.state.ErrorState

interface ViewState {
    val error: ErrorState?
    val navigation: NavDirections?
}