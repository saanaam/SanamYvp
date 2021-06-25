package com.sanam.yavarpour.domain.usecase

import com.sanam.yavarpour.domain.UseCaseResult

data class UseCaseConsumerResult(
    override val message: String = ""
) : UseCaseResult<Any?>(null, message)