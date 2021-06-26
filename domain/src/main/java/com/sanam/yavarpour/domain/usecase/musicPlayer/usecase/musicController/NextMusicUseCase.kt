package com.sanam.yavarpour.domain.usecase.musicPlayer.usecase.musicController

import com.sanam.yavarpour.domain.UseCaseResult
import com.sanam.yavarpour.domain.usecase.SingleUseCase
import com.sanam.yavarpour.domain.usecase.musicPlayer.usecase.playingMusicUseCase.model.PlayingMusicModel
import com.sanam.yavarpour.domain.usecase.musicPlayer.repository.MusicListControllerRepository
import javax.inject.Inject

class NextMusicUseCase @Inject constructor(
    private val musicListRepository: MusicListControllerRepository
) : SingleUseCase<Pair<Boolean, Int>, Pair<PlayingMusicModel?, String?>>() {

    override suspend fun task(request: Pair<Boolean, Int>): UseCaseResult<Pair<PlayingMusicModel?, String?>> {
        return UseCaseResult(data = musicListRepository.nextMusic(request.first, request.second))
    }
}