package com.nar.bimito.domain

open class UseCaseResult<D>(
    val data: D,
    open val message: String = ""
)