package com.nar.bimito.common.util

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Transformations


fun <X, Y> LiveData<X>.map(body: (X) -> Y): LiveData<Y> {
    return Transformations.map(this, body)
}

fun <X, Y> LiveData<X>.switchMap(body: (X) -> LiveData<Y>): LiveData<Y> {
    return Transformations.switchMap(this, body)
}

inline fun <T> LiveData<T>.filter(crossinline predicate: (T?) -> Boolean): LiveData<T> {
    val mediator = MediatorLiveData<T>()
    mediator.addSource(this) {
        if (predicate(it)) {
            mediator.value = it
        }
    }

    return mediator
}

fun <T> LiveData<T>.take(count: Int): LiveData<T> {
    val mediator = MediatorLiveData<T>()
    var taken = 0
    mediator.addSource(this) {
        if (taken < count) {
            mediator.value = it
            taken++
        } else {
            mediator.removeSource(this)
        }
    }

    return mediator
}

inline fun <T> LiveData<T>.takeUntil(crossinline predicate: (T?) -> Boolean): LiveData<T> {
    val mediator = MediatorLiveData<T>()
    mediator.addSource(this) {
        if (predicate(it)) {
            mediator.value = it
        } else {
            mediator.removeSource(this)
        }
    }

    return mediator
}

fun <T> LiveData<T>.skip(count: Int): LiveData<T> {
    val mediator = MediatorLiveData<T>()
    var skipped = 0
    mediator.addSource(this) {
        if (skipped >= count) {
            mediator.value = it
        } else {
            skipped++
        }
    }

    return mediator
}

inline fun <T> LiveData<T>.skipUntil(crossinline predicate: (T?) -> Boolean): LiveData<T> {
    val mediator = MediatorLiveData<T>()
    var metPredicate = false
    mediator.addSource(this) {
        if (metPredicate || predicate(it)) {
            metPredicate = true
            mediator.value = it
        }
    }

    return mediator
}