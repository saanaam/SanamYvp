package com.nar.bimito.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.nar.bimito.common.exception.PresentationExceptionAbstractFactory
import com.nar.bimito.common.exception.PresentationExceptionDecorator
import com.nar.bimito.common.exception.PresentationExceptionFactory
import com.nar.bimito.common.state.ViewState
import com.nar.bimito.domain.UseCase
import com.nar.bimito.domain.exception.AuthorizationException
import java.net.UnknownHostException


abstract class AbstractViewModel<V : ViewState>(
    viewState: V,
) : ViewModel() {

    val exceptionFactory: PresentationExceptionAbstractFactory = PresentationExceptionFactory()

    open var exceptionFactoryDecorator: PresentationExceptionDecorator? = null

    protected val _viewState = SingleLiveEvent<V>()
    val viewState: LiveData<V> = _viewState

    init {
        _viewState.value = viewState
        _viewState.postValue(viewState)
    }

    protected fun isAuthenticationError(throwable: Throwable): Boolean {
        return (throwable is AuthorizationException)
    }

    protected fun isNetworkConnectionError(throwable: Throwable): Boolean {
        return (throwable is UnknownHostException)
    }

    open fun clearViewModel() {

    }


}

