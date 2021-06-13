package com.sanam.yavarpour.domain.usecase

import com.sanam.yavarpour.domain.AsynchronousUseCase
import com.sanam.yavarpour.domain.UseCaseResponse
import com.sanam.yavarpour.domain.UseCaseResult
import com.sanam.yavarpour.domain.exception.UseCaseAlreadyDisposedException
import kotlinx.coroutines.launch

abstract class SupplierUseCase<Res> : AsynchronousUseCase<Res>() {

    fun perform(func: UseCaseResponse<Res>.() -> Unit) {

        if (disposed) throw UseCaseAlreadyDisposedException(
            this::class
        )
        response?.let { func(it) }
        launchTask()
    }

    private fun launchTask() {
        response?.inProgress = true
        useCaseScope.launch {
            try {
                val taskResult = task()
                response?.onSuccess?.invoke(taskResult)
            } catch (e: Throwable) {
                response?.onError?.invoke(e)
            }
            response?.inProgress = false
            response?.onFinish?.invoke()
        }
    }

    protected abstract suspend fun task(): UseCaseResult<Res>

}
