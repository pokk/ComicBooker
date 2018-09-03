package com.no1.taiwan.comicbooker.data.datastores

import com.devrapid.kotlinshaver.cast
import com.no1.taiwan.comicbooker.data.local.cache.Cache

/**
 * An abstract class for this project and pre-defined the some functions for this app keeping the data.
 */
abstract class AbsCache : Cache {
    inline fun <reified T> digCachedData(which: Int, params: Any) = cast<T>(obtainCachedObj(which, params))

    fun isDirtyAndNotCached(which: Int, params: Any) = isDirty(which, params) || !isCached(which, params)
}
