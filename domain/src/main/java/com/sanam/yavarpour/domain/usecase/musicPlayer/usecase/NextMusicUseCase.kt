package com.sanam.yavarpour.domain.usecase.musicPlayer.usecase

import com.sanam.yavarpour.domain.UseCaseResult
import com.sanam.yavarpour.domain.usecase.SingleUseCase
import com.sanam.yavarpour.domain.usecase.musicPlayer.model.PlayingMusicModel
import com.sanam.yavarpour.domain.usecase.musicPlayer.repository.MusicListControllerRepository
import javax.inject.Inject

class NextMusicUseCase @Inject constructor(
    private val musicListRepository: MusicListControllerRepository
) : SingleUseCase<Pair<Boolean, Int>, Pair<PlayingMusicModel?, String?>>() {

    override suspend fun task(request: Pair<Boolean, Int>): UseCaseResult<Pair<PlayingMusicModel?, String?>> {
        return UseCaseResult(data = musicListRepository.nextMusic(request.first, request.second))
    }
}