package com.nar.bimito.domain.util


fun Any?.isNull(): Boolean {
    return this == null
}

fun Any?.isNotNull(): Boolean {
    return !this.isNull()
}

public fun <T> Collection<T>?.isNotNullOrEmpty(): Boolean {
    return this != null && !this.isEmpty()
}


val String?.length: Int
    get() {
        return if (this.isNullOrEmpty()) {
            0
        } else {
            this.length
        }
    }

