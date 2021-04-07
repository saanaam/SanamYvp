package com.nar.bimito.remote


interface DtoMapper<in T, out D> {

    fun mapToData(dto: T?): D

}