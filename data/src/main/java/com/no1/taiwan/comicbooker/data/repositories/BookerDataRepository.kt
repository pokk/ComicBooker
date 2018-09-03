package com.no1.taiwan.comicbooker.data.repositories

import com.no1.taiwan.comicbooker.data.datas.mappers.MapperPool
import com.no1.taiwan.comicbooker.data.datastores.AbsCache
import com.no1.taiwan.comicbooker.data.datastores.DataStore
import com.no1.taiwan.comicbooker.domain.repositories.DataRepository

/**
 * The data repository for being responsible for selecting an appropriate data store to access
 * the data.
 *
 * @property cache cache data store.
 * @property local from database/file/memory data store.
 * @property remote from remote service/firebase/third-party service data store.
 * @property mapperPool keeping all of the data mapper here.
 */
class BookerDataRepository constructor(
    private val cache: AbsCache,
    private val local: DataStore,
    private val remote: DataStore,
    private val mapperPool: MapperPool
) : DataRepository {
    companion object {
        const val SWITCH = false
    }
}
