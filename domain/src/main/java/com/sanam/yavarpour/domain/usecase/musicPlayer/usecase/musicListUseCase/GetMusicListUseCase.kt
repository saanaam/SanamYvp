package com.sanam.yavarpour.domain.usecase.musicPlayer.usecase.musicListUseCase

import com.sanam.yavarpour.domain.UseCaseResult
import com.sanam.yavarpour.domain.usecase.SupplierUseCase
import com.sanam.yavarpour.domain.usecase.musicPlayer.repository.MusicListControllerRepository
import com.sanam.yavarpour.domain.usecase.musicPlayer.usecase.musicListUseCase.model.MusicModel
import javax.inject.Inject

class GetMusicListUseCase @Inject constructor(
    private val musicListRepository: MusicListControllerRepository
) : SupplierUseCase<ArrayList<MusicModel>>() {
    override suspend fun task(): UseCaseResult<ArrayList<MusicModel>> {
        return UseCaseResult(data = musicListRepository.getMusicList())
    }
}