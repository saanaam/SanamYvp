package com.nar.bimito.common

import com.nar.bimito.domain.Entity

interface PresentationMapper<E : Entity, P : PresentationModel> {

    fun toPresentation(entity: E): P
}