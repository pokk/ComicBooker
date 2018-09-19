package com.no1.taiwan.comicbooker.data.datastores

import com.no1.taiwan.comicbooker.data.local.services.BookerDatabase
import com.no1.taiwan.comicbooker.domain.parameters.Parameterable

/**
 * The implementation of the local data store. The responsibility is selecting a correct
 * local service(Database/Local file) to access the data.
 */
class LocalDataStore(
    private val database: BookerDatabase
) : DataStore {
    override fun retrieveTest(parameters: Parameterable) = throw UnsupportedOperationException()
}
