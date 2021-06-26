package com.sanam.yavarpour.local.repository

import com.sanam.yavarpour.MusicListMock
import com.sanam.yavarpour.domain.usecase.musicPlayer.model.CurrentMusicStateModel
import com.sanam.yavarpour.domain.usecase.musicPlayer.model.MusicModel
import com.sanam.yavarpour.domain.usecase.musicPlayer.model.PlayingMusicModel
import com.sanam.yavarpour.domain.usecase.musicPlayer.repository.MusicListControllerRepository
import com.sanam.yavarpour.local.localDataSource.MusicListControllerDataSource
import javax.inject.Inject
import kotlin.collections.ArrayList

class MusicListControllerDataRepository @Inject constructor(
    private val musicListControllerDataSource: MusicListControllerDataSource
) : MusicListControllerRepository {

    override suspend fun getMusicList() =
        musicListControllerDataSource.getMusicList()

    override suspend fun setMusicList(isPremium: Boolean) {
        if (isPremium)
            musicListControllerDataSource.setMusicList(MusicListMock().musicList())
        else {
            musicListControllerDataSource.setMusicList(
                MusicListMock().musicList().shuffle() as ArrayList<MusicModel>
            )
        }
    }

    override suspend fun updatePlayingMusic(currentMusicId: Int) =
        musicListControllerDataSource.updatePlayingMusic(currentMusicId)

    override suspend fun getPlayingMusic(): PlayingMusicModel? {
        val playingMusicId = musicListControllerDataSource.getPlayingMusic()
        return musicListControllerDataSource.getMusicListInfo().find { it.id == playingMusicId }
    }

    override suspend fun updateMusicState(item: CurrentMusicStateModel) =
        musicListControllerDataSource.updateMusicState(item)

    override suspend fun getLatestMusicState() =
        musicListControllerDataSource.getLatestMusicStateModel()

    override suspend fun nextMusic(
        isPremium: Boolean,
        currentMusicId: Int
    ): Pair<PlayingMusicModel?, String?> {
        return if (isPremium) {
            //get music list and find the previous index
            val musicList = musicListControllerDataSource.getMusicList()
            val nextMusicIndex = musicList.indexOf(MusicModel(currentMusicId)) + 1
            val nextMusicModel: MusicModel = musicList[nextMusicIndex]
            updatePlayingMusic(nextMusicModel.id)
            val playingMusicModel =
                musicListControllerDataSource.getMusicListInfo().find { it.id == nextMusicModel.id }
            Pair(playingMusicModel, null)
        } else {
            Pair(null, "Go to Premium")
        }
    }

    override suspend fun previousMusic(
        isPremium: Boolean,
        currentMusicId: Int
    ): Pair<PlayingMusicModel?, String?> {
        return if (isPremium) {
            //get music list and find the previous index
            val musicList = musicListControllerDataSource.getMusicList()
            val nextMusicIndex = musicList.indexOf((currentMusicId)) - 1
            val nextMusicModel: MusicModel = musicList[nextMusicIndex]
            updatePlayingMusic(nextMusicModel.id)
            val playingMusicModel =
                musicListControllerDataSource.getMusicListInfo().find { it.id == nextMusicModel.id }
            Pair(playingMusicModel, null)
        } else {
            Pair(null, "Go to Premium")
        }
    }

    override suspend fun addMusicToQue(musicId: Int) : ArrayList<MusicModel> {
        val musicList = musicListControllerDataSource.getMusicList()
        val currentMusicIndex = musicList.indexOf((getPlayingMusic()?.id!!))
        musicList.add(currentMusicIndex + 1, MusicModel(musicId))
        return musicList
    }

}