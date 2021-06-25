package com.sanam.yavarpour.domain.usecase

import com.sanam.yavarpour.domain.AsynchronousUseCase
import com.sanam.yavarpour.domain.UseCaseResponse
import com.sanam.yavarpour.domain.exception.UseCaseAlreadyDisposedException
import kotlinx.coroutines.launch

abstract class ConsumerUseCase<in Req> : AsynchronousUseCase<Any?>() {

    fun perform(request: Req, func: UseCaseResponse<Any?>.() -> Unit) {

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

    protected abstract suspend fun task(request: Req): UseCaseConsumerResult

}
