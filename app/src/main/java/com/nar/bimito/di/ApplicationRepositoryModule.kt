package com.nar.bimito.di

import com.nar.bimito.remote.data.onlineDataSource.appVersion.AppVersionDataRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import com.nar.bimito.domain.usecase.appVersion.repository.AppVersionRepository
import com.nar.bimito.presentation.splash.main.model.AppVersionPresentationMapper
import com.nar.bimito.presentation.splash.main.model.AppVersionPresentationMapperImp
import com.nar.bimito.remote.data.onlineDataSource.appVersion.dto.AppVersionResponseDtoMapper
import com.nar.bimito.remote.data.onlineDataSource.appVersion.dto.AppVersionResponseDtoMapperImp
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
abstract class ApplicationRepositoryModule {

    @Binds
    abstract fun provideAppVersionDataRepository(
        appVersionDataRepository: AppVersionDataRepository
    ): AppVersionRepository


    @Binds
    abstract fun provideAppVersionResponseDtoMapperImp(
        mapper: AppVersionResponseDtoMapperImp
    ): AppVersionResponseDtoMapper

    @Binds
    abstract fun provideAppVersionPresentationMapperImp(
        mapper: AppVersionPresentationMapperImp
    ): AppVersionPresentationMapper

}