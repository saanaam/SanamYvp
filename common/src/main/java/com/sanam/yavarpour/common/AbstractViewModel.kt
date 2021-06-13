package com.sanam.yavarpour.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.sanam.yavarpour.common.state.ViewState


abstract class AbstractViewModel<V : ViewState>(
    viewState: V,
) : ViewModel() {

    protected val _viewState = SingleLiveEvent<V>()
    val viewState: LiveData<V> = _viewState

    init {
        _viewState.value = viewState
        _viewState.postValue(viewState)
    }

    open fun clearViewModel() {

    }


}

