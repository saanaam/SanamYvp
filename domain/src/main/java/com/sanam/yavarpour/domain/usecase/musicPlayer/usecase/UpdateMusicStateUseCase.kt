package com.sanam.yavarpour.domain.usecase.musicPlayer.usecase

import com.sanam.yavarpour.domain.usecase.ConsumerUseCase
import com.sanam.yavarpour.domain.usecase.UseCaseConsumerResult
import com.sanam.yavarpour.domain.usecase.musicPlayer.model.CurrentMusicStateModel
import com.sanam.yavarpour.domain.usecase.musicPlayer.repository.MusicListControllerRepository
import javax.inject.Inject

class UpdateMusicStateUseCase @Inject constructor(
    private val musicListRepository: MusicListControllerRepository
) : ConsumerUseCase<CurrentMusicStateModel>() {
    override suspend fun task(request: CurrentMusicStateModel): UseCaseConsumerResult {
        musicListRepository.updateMusicState(request)
        return UseCaseConsumerResult()
    }
}