package com.sanam.yavarpour.domain.usecase.musicPlayer.usecase.musicStateUseCase

import com.sanam.yavarpour.domain.UseCaseResult
import com.sanam.yavarpour.domain.usecase.SupplierUseCase
import com.sanam.yavarpour.domain.usecase.musicPlayer.usecase.musicStateUseCase.model.CurrentMusicStateModel
import com.sanam.yavarpour.domain.usecase.musicPlayer.repository.MusicListControllerRepository
import javax.inject.Inject

class GetLatestMusicStateUseCase @Inject constructor(
    private val musicListRepository: MusicListControllerRepository
) : SupplierUseCase<CurrentMusicStateModel>() {
    override suspend fun task(): UseCaseResult<CurrentMusicStateModel> {
        return UseCaseResult(data = musicListRepository.getLatestMusicState())
    }
}