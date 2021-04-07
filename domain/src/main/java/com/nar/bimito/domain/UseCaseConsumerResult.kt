package com.nar.bimito.domain

data class UseCaseConsumerResult(
    override val message: String = ""
) : UseCaseResult<Any?>(null, message)