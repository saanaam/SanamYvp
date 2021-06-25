package com.sanam.yavarpour.di

import com.sanam.database.dataSource.MusicListControllerLocalDataSource
import com.sanam.yavarpour.local.localDataSource.MusicListControllerDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class ApplicationDataSourceModule {
    @Binds
    abstract fun provideGetUserMusicListLocalDataSource(
        getUserMusicListLocalDataSource: MusicListControllerLocalDataSource
    ): MusicListControllerDataSource

}