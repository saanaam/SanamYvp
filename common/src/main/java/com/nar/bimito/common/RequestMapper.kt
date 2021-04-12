package com.nar.bimito.common

import com.nar.bimito.domain.Request

interface RequestMapper<P : PresentationModel, R : Request> {

    fun toRequest(presentationModel: P): R
}