package com.no1.taiwan.comicbooker.data.datastores

import kotlinx.coroutines.experimental.Deferred

interface DataStore {
    fun retrieveTest(): Deferred<Boolean>
}
