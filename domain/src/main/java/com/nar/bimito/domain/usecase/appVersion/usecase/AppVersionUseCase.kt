package com.nar.bimito.domain.usecase.appVersion.usecase

import com.nar.bimito.domain.UseCaseResult
import com.nar.bimito.domain.usecase.SupplierUseCase
import com.nar.bimito.domain.usecase.appVersion.model.AppVersionResponse
import com.nar.bimito.domain.usecase.appVersion.repository.AppVersionRepository
import javax.inject.Inject

class AppVersionUseCase @Inject constructor(
    private val appVersionRepository: AppVersionRepository
) : SupplierUseCase<AppVersionResponse>() {

    override suspend fun task(): UseCaseResult<AppVersionResponse> {
        return UseCaseResult(data = appVersionRepository.appVersion())
    }
}