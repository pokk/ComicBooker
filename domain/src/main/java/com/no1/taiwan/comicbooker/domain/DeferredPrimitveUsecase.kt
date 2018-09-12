package com.no1.taiwan.comicbooker.domain

import kotlinx.coroutines.IO
import kotlinx.coroutines.async

abstract class DeferredPrimitveUsecase<T, R : BaseUsecase.RequestValues> : BaseUsecase<R>() {
    suspend fun execute(parameter: R? = null) = run {
        parameter?.let { requestValues = it }

        async(IO, parent = parentJob) { fetchCase() }.await()
    }

    abstract suspend fun fetchCase(): T
}
