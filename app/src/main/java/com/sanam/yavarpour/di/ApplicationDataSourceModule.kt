package com.sanam.yavarpour.di

import com.sanam.database.dataSource.GetUserMusicListLocalDataSource
import com.sanam.yavarpour.local.localDataSource.GetUserMusicListDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class ApplicationDataSourceModule {
    @Binds
    abstract fun provideGetUserMusicListLocalDataSource(
        getUserMusicListLocalDataSource: GetUserMusicListLocalDataSource
    ): GetUserMusicListDataSource


}