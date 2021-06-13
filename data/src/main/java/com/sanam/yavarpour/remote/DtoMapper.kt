package com.sanam.yavarpour.remote


interface DtoMapper<in T, out D> {

    fun mapToData(dto: T?): D

}