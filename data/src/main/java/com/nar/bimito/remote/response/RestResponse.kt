package com.nar.bimito.remote.response

import com.google.gson.annotations.SerializedName
import com.nar.bimito.remote.Dto


open class RestResponse<R> : Dto {

    @SerializedName("result")
    var result: R? = null

    @SerializedName("message")
    var message: String? = null

    @SerializedName("messageCode")
     var messageCode: Int? = null

}