package com.no1.taiwan.comicbooker.domain

abstract class DeferredUsecase<T, R : BaseUsecase.RequestValues> : BaseUsecase<R>() {
    private val deferred = CompletableDeferred<T>()

    suspend fun execute(parameter: R): T {
        requestValues = parameter

        return fetchCase()
    }

    abstract suspend fun fetchCase(): T
}
