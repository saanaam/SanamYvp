package com.nar.bimito.di

import com.nar.bimito.remote.data.onlineDataSource.appVersion.AppVersionApiService
import com.nar.bimito.remote.data.onlineDataSource.appVersion.AppVersionOnlineDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
abstract class ApplicationDataSourceModule {

    @Binds
    abstract fun provideAppVersionOnlineDataSource(
        appVersionApiService: AppVersionApiService
    ): AppVersionOnlineDataSource
}