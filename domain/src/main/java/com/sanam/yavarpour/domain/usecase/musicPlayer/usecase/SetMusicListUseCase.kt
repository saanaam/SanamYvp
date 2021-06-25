package com.sanam.yavarpour.domain.usecase.musicPlayer.usecase

import com.sanam.yavarpour.domain.usecase.ConsumerUseCase
import com.sanam.yavarpour.domain.usecase.UseCaseConsumerResult
import com.sanam.yavarpour.domain.usecase.musicPlayer.repository.MusicListControllerRepository
import javax.inject.Inject

class SetMusicListUseCase @Inject constructor(
    private val musicListRepository: MusicListControllerRepository
) : ConsumerUseCase<Boolean>() {
    override suspend fun task(isPremium: Boolean): UseCaseConsumerResult {
        musicListRepository.setMusicList(isPremium)
        return UseCaseConsumerResult()
    }
}