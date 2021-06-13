package com.sanam.yavarpour.domain

open class UseCaseResult<D>(
    val data: D,
    open val message: String = ""
)