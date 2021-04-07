package com.nar.bimito.remote.adapter

interface CallAdapter<R> {
    suspend fun execute(): R
}