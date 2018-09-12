package com.no1.taiwan.comicbooker.domain

abstract class DeferredUsecase<T, R : BaseUsecase.RequestValues> : BaseUsecase<R>() {
    suspend fun execute(parameter: R? = null) = run {
        parameter?.let { requestValues = it }

        fetchCase()
    }

    abstract suspend fun fetchCase(): T
}
