package com.sanam.yavarpour


interface DtoMapper<in T, out D> {

    fun mapToData(dto: T?): D

}