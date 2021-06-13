package com.sanam.yavarpour.domain.exception

import kotlin.reflect.KClass

open class DomainException(message: String? = null) : RuntimeException(message)

class UseCaseAlreadyDisposedException(clazz: KClass<out Any>) :
    DomainException("Trying to perform already disposed usecase : ${clazz.java.name}")

