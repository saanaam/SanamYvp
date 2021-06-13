package com.sanam.yavarpour.domain.usecase.appVersion.usecase

import com.sanam.yavarpour.domain.UseCaseResult
import com.sanam.yavarpour.domain.usecase.SupplierUseCase
import com.sanam.yavarpour.domain.usecase.appVersion.model.MusicListResponse
import com.sanam.yavarpour.domain.usecase.appVersion.repository.MusicListRepository
import javax.inject.Inject

class MusicListUseCase @Inject constructor(
    private val musicListRepository: MusicListRepository
) : SupplierUseCase<ArrayList<MusicListResponse>>() {

    override suspend fun task(): UseCaseResult<ArrayList<MusicListResponse>> {
        return UseCaseResult(data = musicListRepository.getMusicList())
    }
}