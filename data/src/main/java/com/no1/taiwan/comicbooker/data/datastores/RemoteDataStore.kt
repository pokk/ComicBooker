package com.no1.taiwan.comicbooker.data.datastores

import com.no1.taiwan.comicbooker.data.remote.services.BookerFirebase
import com.no1.taiwan.comicbooker.data.remote.services.BookerService
import com.no1.taiwan.comicbooker.domain.parameters.Parameterable

/**
 * The implementation of the remote data store. The responsibility is selecting a correct
 * remote service to access the data.
 */
class RemoteDataStore(
    private val bookerService: BookerService,
    private val bookerFirebase: BookerFirebase
) : DataStore {
    override fun retrieveTest(parameters: Parameterable) = bookerService.retrieveTest(parameters.toApiParam())

    override fun retrieveBookerData(parameters: Parameterable) = throw UnsupportedOperationException()
}
