package com.sanam.yavarpour.common

import com.sanam.yavarpour.domain.Entity

interface PresentationMapper<E : Entity, P : PresentationModel> {

    fun toPresentation(entity: E): P
}