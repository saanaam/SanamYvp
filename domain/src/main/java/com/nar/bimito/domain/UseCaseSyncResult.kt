package com.nar.bimito.domain

import com.nar.bimito.domain.UseCaseResult

data class UseCaseSyncResult(
    override val message: String = "",
    val success: Boolean
) : UseCaseResult<Boolean>(success, message)