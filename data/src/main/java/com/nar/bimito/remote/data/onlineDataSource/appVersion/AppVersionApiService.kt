package com.nar.bimito.remote.data.onlineDataSource.appVersion

import com.nar.bimito.remote.AbstractApiService
import javax.inject.Inject

class AppVersionApiService @Inject constructor():
    AbstractApiService<AppVersionEndpoint>(AppVersionEndpoint::class.java), AppVersionOnlineDataSource{

    override suspend fun appVersion(): String {
        TODO("Not yet implemented")
    }


}