package com.sanam.yavarpour.domain.usecase.appVersion.usecase

import com.sanam.yavarpour.domain.UseCaseResult
import com.sanam.yavarpour.domain.usecase.SingleUseCase
import com.sanam.yavarpour.domain.usecase.SupplierUseCase
import com.sanam.yavarpour.domain.usecase.appVersion.model.MusicModel
import com.sanam.yavarpour.domain.usecase.appVersion.repository.MusicListRepository
import javax.inject.Inject

class MusicListUseCase @Inject constructor(
    private val musicListRepository: MusicListRepository
) : SingleUseCase<Boolean, ArrayList<MusicModel>>() {
    override suspend fun task(isPremium: Boolean): UseCaseResult<ArrayList<MusicModel>> {
        return UseCaseResult(data = musicListRepository.getMusicList(isPremium))
    }

}