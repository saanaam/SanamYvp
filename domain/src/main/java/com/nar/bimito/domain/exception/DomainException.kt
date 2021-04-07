package com.nar.bimito.domain.exception

import kotlin.reflect.KClass

open class DomainException(message: String? = null) : RuntimeException(message)

class AuthorizationException : DomainException(
    "other device has signed with this number and " +
            "encryption key is not valid"
)

class NetworkException(
    message: String?, val code: String? = null,
    val timestamp: Long? = 0
) : DomainException(message ?: "")


class IllegalDataException : DomainException()

class DataNotCachedException : DomainException()

class UseCaseAlreadyDisposedException(clazz: KClass<out Any>) :
    DomainException("Trying to perform already disposed usecase : ${clazz.java.name}")

