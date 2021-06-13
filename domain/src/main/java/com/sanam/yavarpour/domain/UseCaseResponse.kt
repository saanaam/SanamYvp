package com.sanam.yavarpour.domain


data class UseCaseResponse<Res>(
    var inProgress: Boolean = false,
    var onSuccess: ((result: UseCaseResult<Res>) -> Unit)? = null,
    var onError: ((exception: Throwable) -> Unit)? = null,
    var onFinish: (() -> Unit)? = null
)