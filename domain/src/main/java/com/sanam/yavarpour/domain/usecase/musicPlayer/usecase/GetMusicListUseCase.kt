package com.sanam.yavarpour.domain.usecase.musicPlayer.usecase

import com.sanam.yavarpour.domain.UseCaseResult
import com.sanam.yavarpour.domain.usecase.SupplierUseCase
import com.sanam.yavarpour.domain.usecase.musicPlayer.model.MusicModel
import com.sanam.yavarpour.domain.usecase.musicPlayer.repository.MusicListControllerRepository
import javax.inject.Inject

class GetMusicListUseCase @Inject constructor(
    private val musicListRepository: MusicListControllerRepository
) : SupplierUseCase<ArrayList<MusicModel>>() {
    override suspend fun task(): UseCaseResult<ArrayList<MusicModel>> {
        return UseCaseResult(data = musicListRepository.getMusicList())
    }
}