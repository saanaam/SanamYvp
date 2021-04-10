package com.nar.bimito.di.accountManager

import com.nar.bimito.di.accountManager.AccountManager
import com.nar.bimito.di.accountManager.AccountManagerImpl
import com.nar.bimito.di.networkManager.HeaderInterceptorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AccountManagerModule {

    @Binds
    @Singleton
    abstract fun bindAccountService(
        accountManagerImpl: AccountManagerImpl
    ): AccountManager

}