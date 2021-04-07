package com.nar.bimito.domain.usecase

import com.nar.bimito.domain.AsynchronousUseCase
import com.nar.bimito.domain.UseCaseSyncResult

abstract class SyncUseCase : AsynchronousUseCase<Any?>() {
    abstract suspend fun sync(): UseCaseSyncResult

}
