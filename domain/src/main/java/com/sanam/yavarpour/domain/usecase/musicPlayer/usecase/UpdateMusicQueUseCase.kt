package com.sanam.yavarpour.domain.usecase.musicPlayer.usecase

import com.sanam.yavarpour.domain.UseCaseResult
import com.sanam.yavarpour.domain.usecase.SingleUseCase
import com.sanam.yavarpour.domain.usecase.musicPlayer.model.MusicModel
import com.sanam.yavarpour.domain.usecase.musicPlayer.repository.MusicListControllerRepository
import javax.inject.Inject

class UpdateMusicQueUseCase @Inject constructor(
    private val musicListRepository: MusicListControllerRepository
) : SingleUseCase<Int, ArrayList<MusicModel>>() {

    override suspend fun task(request: Int): UseCaseResult<ArrayList<MusicModel>> {
        return UseCaseResult(data = musicListRepository.addMusicToQue(request))
    }

}
