package com.nar.bimito.remote.data

abstract class InMemoryLocal<D : DataModel> : LocalDataSource {
    private var dataStore: MutableList<D> = mutableListOf()

    fun save(data: D) {
        dataStore.add(data)
    }

    fun refresh(dataList: List<D>) {
        dataStore = dataList.toMutableList()
    }


    fun read(): List<D> {
        return dataStore
    }

    fun clear() {
        dataStore.clear()
    }

    fun hasData(): Boolean {
        return dataStore.isNotEmpty()
    }

}