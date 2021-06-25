package com.sanam.yavarpour.di

import com.sanam.database.dto.mapper.*
import com.sanam.yavarpour.local.repository.MusicListControllerDataRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import com.sanam.yavarpour.domain.usecase.musicPlayer.repository.MusicListControllerRepository
import com.sanam.yavarpour.presentation.splash.main.model.AppVersionPresentationMapperImp
import com.sanam.yavarpour.presentation.splash.main.model.MusicListPresentationMapper
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class ApplicationRepositoryModule {

    @Binds
    abstract fun provideAppVersionDataRepository(
        appVersionDataRepository: MusicListControllerDataRepository
    ): MusicListControllerRepository


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


    @Binds
    abstract fun provideMusicListPresentationMapper(
        appVersionPresentationMapperImp: AppVersionPresentationMapperImp
    ): MusicListPresentationMapper


}