package com.no1.taiwan.comicbooker.domain.repositories

import kotlinx.coroutines.Deferred

/**
 * This interface will be the similar to [com.no1.taiwan.comicbooker.data.datastores.DataStore] .
 */
interface DataRepository {
    fun fetchTest(): Deferred<String>
}
