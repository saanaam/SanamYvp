package com.nar.bimito.presentation.splash.main

import com.nar.bimito.common.exception.PresentationExceptionDecorator
import com.nar.bimito.common.state.ErrorState
import com.nar.bimito.presentation.R
import javax.inject.Inject

class MainExceptionDecorator @Inject constructor() : PresentationExceptionDecorator() {
    override fun createException(exception: Throwable, title: Int?): ErrorState? {
        exception.message?.let {
            return ErrorState(message = it)
        } ?: kotlin.run {
            return ErrorState(extraInfo = R.string.exception_unknown_message)
        }
    }

}