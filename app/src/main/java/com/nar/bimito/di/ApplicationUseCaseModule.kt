package com.nar.bimito.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(ViewModelComponent::class)
 class ApplicationUseCaseModule {

//    @Provides
//    fun provideAppVersionUseCase() : AppVersionUseCase = AppVersionUseCase()

//    @Provides
//    fun provideAppVersionUseCase(appVersion: AppVersionRepository) =
//        AppVersionUseCase

}