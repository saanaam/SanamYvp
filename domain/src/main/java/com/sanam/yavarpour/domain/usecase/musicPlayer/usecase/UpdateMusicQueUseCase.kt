package com.sanam.yavarpour.domain.usecase.musicPlayer.usecase

import com.sanam.yavarpour.domain.usecase.ConsumerUseCase
import com.sanam.yavarpour.domain.usecase.UseCaseConsumerResult
import com.sanam.yavarpour.domain.usecase.musicPlayer.repository.MusicListControllerRepository
import javax.inject.Inject

class UpdateMusicQueUseCase @Inject constructor(
    private val musicListRepository: MusicListControllerRepository
) : ConsumerUseCase<Int>() {
    override suspend fun task(request: Int): UseCaseConsumerResult {
        musicListRepository.addMusicToQue(request)
        return UseCaseConsumerResult()
    }
}
