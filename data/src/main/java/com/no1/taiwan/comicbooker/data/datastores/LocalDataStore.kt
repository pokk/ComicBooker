package com.no1.taiwan.comicbooker.data.datastores

import com.no1.taiwan.comicbooker.data.local.v1.BookerDao
import com.no1.taiwan.comicbooker.domain.parameters.Parameterable
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

/**
 * The implementation of the local data store. The responsibility is selecting a correct
 * local service(Database/Local file) to access the data.
 */
class LocalDataStore(
    private val bookerDb: BookerDao
) : DataStore {
    override fun retrieveTest(parameters: Parameterable) = throw UnsupportedOperationException()

    override fun retrieveBookerData(parameters: Parameterable) =
        GlobalScope.async(Dispatchers.Default, CoroutineStart.DEFAULT, null, { bookerDb.getAllData() })
}
