package com.nar.bimito.domain.usecase

import com.nar.bimito.domain.AsynchronousUseCase
import com.nar.bimito.domain.UseCaseResponse
import com.nar.bimito.domain.UseCaseResult
import com.nar.bimito.domain.exception.UseCaseAlreadyDisposedException
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
