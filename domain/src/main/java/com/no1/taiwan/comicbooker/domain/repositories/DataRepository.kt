package com.no1.taiwan.comicbooker.domain.repositories

import com.no1.taiwan.comicbooker.domain.models.BookerModel
import com.no1.taiwan.comicbooker.domain.models.TestModel
import com.no1.taiwan.comicbooker.domain.parameters.Parameterable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred

/**
 * This interface will be the similar to [com.no1.taiwan.comicbooker.data.datastores.DataStore] .
 */
interface DataRepository {
    fun fetchTest(parameters: Parameterable, scope: CoroutineScope): Deferred<TestModel>

    fun fetchBooker(parameters: Parameterable, scope: CoroutineScope): Deferred<List<BookerModel>>
}
