package com.sanam.yavarpour.di

import com.sanam.yavarpour.remote.data.onlineDataSource.musicList.MusicListApiService
import com.sanam.yavarpour.remote.data.onlineDataSource.musicList.AppVersionOnlineDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class ApplicationDataSourceModule {

    @Binds
    abstract fun provideAppVersionOnlineDataSource(
        appVersionApiService: MusicListApiService
    ): AppVersionOnlineDataSource
}