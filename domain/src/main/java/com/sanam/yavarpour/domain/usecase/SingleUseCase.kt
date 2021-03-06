package com.sanam.yavarpour.domain.usecase

import com.sanam.yavarpour.domain.AsynchronousUseCase
import com.sanam.yavarpour.domain.UseCaseResponse
import com.sanam.yavarpour.domain.UseCaseResult
import com.sanam.yavarpour.domain.exception.UseCaseAlreadyDisposedException
import kotlinx.coroutines.launch


abstract class SingleUseCase<in Req, Res> : AsynchronousUseCase<Res>() {

    fun perform(request: Req, func: UseCaseResponse<Res>.() -> Unit) {
        if (disposed) throw UseCaseAlreadyDisposedException(
            this::class
        )
        response?.let { func(it) }
        launchTask(request)
    }

    private fun launchTask(request: Req) {
        response?.inProgress = true
        useCaseScope.launch {
            try {
                val taskResult = task(request)
                response?.onSuccess?.invoke(taskResult)
            } catch (e: Throwable) {
                response?.onError?.invoke(e)
            }
            response?.inProgress = false
            response?.onFinish?.invoke()
        }
    }

    protected abstract suspend fun task(request: Req): UseCaseResult<Res>

}
