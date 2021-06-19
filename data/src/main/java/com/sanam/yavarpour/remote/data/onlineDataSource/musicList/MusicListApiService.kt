package com.sanam.yavarpour.remote.data.onlineDataSource.musicList

import android.app.Application
import android.content.res.AssetFileDescriptor
import com.sanam.yavarpour.domain.usecase.appVersion.model.MusicListResponse
import com.sanam.yavarpour.remote.data.onlineDataSource.musicList.dto.MusicListResponseDto
import com.sanam.yavarpour.remote.data.onlineDataSource.musicList.dto.MusicListResponseDtoMapper
import javax.inject.Inject


class MusicListApiService @Inject constructor(
    private val context : Application,
    private val musicListResponseDtoMapper: MusicListResponseDtoMapper
    ): AppVersionOnlineDataSource{

    override suspend fun getMusicList(): ArrayList<MusicListResponse> {

        val item1: AssetFileDescriptor = context.assets.openFd("Ashvan.mp3")
        val item2: AssetFileDescriptor = context.assets.openFd("Babak.mp3")
        val item3: AssetFileDescriptor = context.assets.openFd("Ah-Zaman.mp3")
        val item4: AssetFileDescriptor = context.assets.openFd("Derya-Ulug.mp3")
        val item5: AssetFileDescriptor = context.assets.openFd("Gülben-Ergen.mp3")

        val mockData = ArrayList<MusicListResponseDto>().apply {
            add(MusicListResponseDto(1, item1))
            add(MusicListResponseDto(2, item2))
            add(MusicListResponseDto(3, item3))
            add(MusicListResponseDto(4, item4))
            add(MusicListResponseDto(5, item5))
            add(MusicListResponseDto(6, item1))
            add(MusicListResponseDto(7, item2))
            add(MusicListResponseDto(8,item3))
            add(MusicListResponseDto(9, item4))
            add(MusicListResponseDto(10, item5))
        }
        return ArrayList<MusicListResponse>().apply {
            for (items in mockData) {
                this.add(musicListResponseDtoMapper.mapToData(items))
            }
        }
    }

}