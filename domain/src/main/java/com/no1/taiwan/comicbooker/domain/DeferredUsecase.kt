package com.no1.taiwan.comicbooker.domain

import kotlinx.coroutines.experimental.Deferred

abstract class DeferredUsecase<T, R : BaseUsecase.RequestValues> : BaseUsecase<R>() {
    fun execute(parameter: R): Deferred<T> {
        requestValues = parameter
        return fetchCase()
    }

    abstract fun fetchCase(): Deferred<T>
}
