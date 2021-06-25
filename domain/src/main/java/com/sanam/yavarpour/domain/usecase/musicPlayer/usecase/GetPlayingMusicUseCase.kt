package com.sanam.yavarpour.domain.usecase.musicPlayer.usecase

import com.sanam.yavarpour.domain.UseCaseResult
import com.sanam.yavarpour.domain.usecase.SupplierUseCase
import com.sanam.yavarpour.domain.usecase.musicPlayer.model.PlayingMusicModel
import com.sanam.yavarpour.domain.usecase.musicPlayer.repository.MusicListControllerRepository
import javax.inject.Inject

class GetPlayingMusicUseCase @Inject constructor(
    private val musicListRepository: MusicListControllerRepository
) : SupplierUseCase<PlayingMusicModel?>() {
    override suspend fun task(): UseCaseResult<PlayingMusicModel?> {
        return UseCaseResult(data = musicListRepository.getPlayingMusic())
    }
}