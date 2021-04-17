package com.nar.bimito.domain.usecase.appVersion.repository

import com.nar.bimito.domain.usecase.appVersion.model.AppVersionResponse

interface AppVersionRepository {
    suspend fun appVersion(): AppVersionResponse
}