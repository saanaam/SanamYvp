package com.nar.bimito.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.nar.bimito.common.state.ViewState
import java.net.UnknownHostException


abstract class AbstractViewModel<V : ViewState>(
    viewState: V
) : ViewModel() {


//    val exceptionFactory: PresentationExceptionAbstractFactory = PresentationExceptionFactory()

//    open var exceptionFactoryDecorator: PresentationExceptionDecorator? = null

    protected val _viewState = SingleLiveEvent<V>()
    val viewState: LiveData<V> = _viewState

    init {
        _viewState.value = viewState
    }

//    protected fun isAuthenticationError(throwable: Throwable): Boolean {
//        return (throwable is AuthorizationException)
//    }

    protected fun isNetworkConnectionError(throwable: Throwable): Boolean {
        return (throwable is UnknownHostException)
    }

    open fun clearViewModel() {
        // no code
    }


}

