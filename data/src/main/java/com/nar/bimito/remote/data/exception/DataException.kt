package com.nar.bimito.remote.data.exception

open class DataException(message:String?=null) : RuntimeException(message)



class UpdateCacheException: DataException("error while updating cache")