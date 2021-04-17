package com.nar.bimito.common.exception

import androidx.annotation.StringRes
import com.nar.bimito.common.state.ErrorState

interface PresentationExceptionAbstractFactory {
    fun create(exception: Throwable, @StringRes title: Int? = null): ErrorState
}