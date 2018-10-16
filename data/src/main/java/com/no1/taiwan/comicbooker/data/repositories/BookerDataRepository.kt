package com.no1.taiwan.comicbooker.data.repositories

import com.devrapid.kotlinshaver.cast
import com.no1.taiwan.comicbooker.data.datas.DataMapper
import com.no1.taiwan.comicbooker.data.datas.MapperPool
import com.no1.taiwan.comicbooker.data.datas.mappers.BookerMapper
import com.no1.taiwan.comicbooker.data.datas.mappers.TestMapper
import com.no1.taiwan.comicbooker.data.datastores.DataStore
import com.no1.taiwan.comicbooker.data.local.cache.AbsCache
import com.no1.taiwan.comicbooker.domain.parameters.Parameterable
import com.no1.taiwan.comicbooker.domain.repositories.DataRepository
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

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
    private val testMapper by lazy { digDataMapper<TestMapper>() }
    private val bookerMapper by lazy { digDataMapper<BookerMapper>() }

    // TODO(jieyi): 2018/09/19 Added try catch for get a mapper from di.
    override fun fetchTest(parameters: Parameterable) =
        GlobalScope.async(Dispatchers.Default, CoroutineStart.DEFAULT, null, {
            val data = remote.retrieveTest(parameters).await()
            testMapper.toModelFrom(data)
        })

    override fun fetchBooker(parameters: Parameterable) =
        GlobalScope.async(Dispatchers.Default, CoroutineStart.DEFAULT, null, {
            val data = local.retrieveBookerData(parameters).await()
            data.map(bookerMapper::toModelFrom).apply {
                println("=================================================")
                println(this)
                println("=================================================")
            }
        })

    /**
     * Get a mapper object from the mapper pool.
     */
    private inline fun <reified DM : DataMapper> digDataMapper() = cast<DM>(mapperPool[DM::class.java])
}
