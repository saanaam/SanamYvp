package com.sanam.yavarpour.remote.data.onlineDataSource.musicList

import com.sanam.yavarpour.domain.usecase.appVersion.model.MusicListResponse
import com.sanam.yavarpour.remote.data.onlineDataSource.musicList.dto.MusicListResponseDto
import com.sanam.yavarpour.remote.data.onlineDataSource.musicList.dto.MusicListResponseDtoMapper
import javax.inject.Inject

class MusicListApiService @Inject constructor(
    private val musicListResponseDtoMapper: MusicListResponseDtoMapper
    ): AppVersionOnlineDataSource{

    override suspend fun getMusicList(): ArrayList<MusicListResponse> {
        val mockData = ArrayList<MusicListResponseDto>().apply {
            add(MusicListResponseDto(1, "setFire", "Addle", "3:00"))
            add(MusicListResponseDto(2, "No Promisses", "jojo", "4:00"))
            add(MusicListResponseDto(3, "I dont wanna Grow Up ", "Bebe Rexha", "2:00"))
            add(MusicListResponseDto(4, "Hands to myself", "selena", "3:00"))
            add(MusicListResponseDto(5, "I Dont care", "Sheeran", "3:00"))
        }
        return ArrayList<MusicListResponse>().apply {
            for (items in mockData) {
                this.add(musicListResponseDtoMapper.mapToData(items))
            }
        }
    }

}