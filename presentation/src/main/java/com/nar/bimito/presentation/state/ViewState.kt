package com.nar.bimito.presentation.state

import androidx.navigation.NavDirections
import com.nar.bimito.presentation.state.ErrorState

interface ViewState {
    val error: ErrorState?
    val navigation: NavDirections?
}