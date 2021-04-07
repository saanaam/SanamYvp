package com.nar.bimito.remote.data

import com.nar.bimito.domain.Entity
import java.util.*

interface DataMapper<D : DataModel, E : Entity> {
    fun mapToEntity(data: D, locale: Locale? = null): E
}