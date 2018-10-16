package com.no1.taiwan.comicbooker.domain.repositories

import com.no1.taiwan.comicbooker.domain.models.BookerModel
import com.no1.taiwan.comicbooker.domain.models.TestModel
import com.no1.taiwan.comicbooker.domain.parameters.Parameterable
import kotlinx.coroutines.Deferred

/**
 * This interface will be the similar to [com.no1.taiwan.comicbooker.data.datastores.DataStore] .
 */
interface DataRepository {
    fun fetchTest(parameters: Parameterable): Deferred<TestModel>

    fun fetchBooker(parameters: Parameterable): Deferred<List<BookerModel>>
}
