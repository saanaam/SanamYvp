package com.nar.bimito.domain

import com.nar.bimito.domain.UseCase
import com.nar.bimito.domain.UseCaseResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelChildren

open class AsynchronousUseCase<Res> : UseCase<Res> {
    private val job = SupervisorJob()
    protected val useCaseScope = CoroutineScope(Dispatchers.IO + job)
    protected var response: UseCaseResponse<Res>? =
        UseCaseResponse()
        private set

    var disposed = false
        private set

    open fun dispose() {
        useCaseScope.coroutineContext.cancelChildren()
        disposed = true
        response = null
    }
}