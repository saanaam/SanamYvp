package com.nar.bimito.remote.response

import com.nar.bimito.remote.Dto
import com.google.gson.annotations.SerializedName


open class RestResponse<R> : Dto {
    @SerializedName("data")
    var data: R? = null

    @SerializedName("message")
    var message: String? = null

}