package com.sanam.yavarpour.di

import com.sanam.database.dto.mapper.*
import com.sanam.yavarpour.local.repository.MusicListDataRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import com.sanam.yavarpour.domain.usecase.appVersion.repository.MusicListRepository
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class ApplicationRepositoryModule {

    @Binds
    abstract fun provideAppVersionDataRepository(
        appVersionDataRepository: MusicListDataRepository
    ): MusicListRepository


    @Binds
    abstract fun provideAppVersionResponseDtoMapperImp(
        musicModelDtoMapper: MusicModelDtoMapper
    ): MusicModelDtoMapperI

    @Binds
    abstract fun provideACurrentMusicStateModelDtoMapper(
        currentMusicStateModelDtoMapper: CurrentMusicStateModelDtoMapper
    ): CurrentMusicStateModelDtoMapperI


    @Binds
    abstract fun providePlayingMusicModelDtoMapper(
        playingMusicModelDtoMapper: PlayingMusicModelDtoMapper
    ): PlayingMusicModelDtoMapperI


}