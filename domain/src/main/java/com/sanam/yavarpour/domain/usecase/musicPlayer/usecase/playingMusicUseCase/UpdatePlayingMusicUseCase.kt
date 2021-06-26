package com.sanam.yavarpour.domain.usecase.musicPlayer.usecase.playingMusicUseCase

import com.sanam.yavarpour.domain.usecase.ConsumerUseCase
import com.sanam.yavarpour.domain.usecase.UseCaseConsumerResult
import com.sanam.yavarpour.domain.usecase.musicPlayer.repository.MusicListControllerRepository
import javax.inject.Inject

class UpdatePlayingMusicUseCase @Inject constructor(
    private val musicListRepository: MusicListControllerRepository
) : ConsumerUseCase<Int>() {
    override suspend fun task(currentMusicId: Int): UseCaseConsumerResult {
        musicListRepository.updatePlayingMusic(currentMusicId)
      return UseCaseConsumerResult()
    }
}