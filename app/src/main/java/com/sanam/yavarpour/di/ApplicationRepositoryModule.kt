package com.sanam.yavarpour.di

import com.sanam.yavarpour.remote.data.onlineDataSource.musicList.MusicListDataRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import com.sanam.yavarpour.domain.usecase.appVersion.repository.MusicListRepository
import com.sanam.yavarpour.presentation.splash.main.model.AppVersionPresentationMapper
import com.sanam.yavarpour.presentation.splash.main.model.AppVersionPresentationMapperImp
import com.sanam.yavarpour.remote.data.onlineDataSource.musicList.dto.MusicListResponseDtoMapper
import com.sanam.yavarpour.remote.data.onlineDataSource.musicList.dto.MusicListResponseDtoMapperImp
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
        mapper: MusicListResponseDtoMapperImp
    ): MusicListResponseDtoMapper

    @Binds
    abstract fun provideAppVersionPresentationMapperImp(
        mapper: AppVersionPresentationMapperImp
    ): AppVersionPresentationMapper

}