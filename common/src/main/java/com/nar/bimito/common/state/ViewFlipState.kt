package com.nar.bimito.common.state

sealed class ViewFlipState<out D> : FlipState {
    data class Loading(override val displayChild: Int = WAIT_CHILD) : ViewFlipState<Nothing>()
    data class Success<out D>(
        override val displayChild: Int = SUCCESS_CHILD,
        val data: D
    ) : ViewFlipState<D>()

    data class Error(
        override val displayChild: Int = ERROR_CHILD,
        val message: String
    ) : ViewFlipState<Nothing>()

    data class PlaceHolder(override val displayChild: Int = PLACE_HOLDER) : ViewFlipState<Nothing>()

    companion object {
        const val SUCCESS_CHILD = 0
        const val WAIT_CHILD = 1
        const val ERROR_CHILD = 2
        const val PLACE_HOLDER = 3
    }
}