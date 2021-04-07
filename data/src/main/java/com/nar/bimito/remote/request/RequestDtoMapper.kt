package com.nar.bimito.remote.request

import android.app.DownloadManager


interface RequestDtoMapper<in Q : DownloadManager.Request, R> {
    fun mapToDto(request: Q): R
}