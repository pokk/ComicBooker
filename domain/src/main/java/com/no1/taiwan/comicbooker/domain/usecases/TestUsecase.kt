package com.no1.taiwan.comicbooker.domain.usecases

import com.no1.taiwan.comicbooker.domain.DeferredUsecase
import com.no1.taiwan.comicbooker.domain.parameters.BookerParams
import com.no1.taiwan.comicbooker.domain.repositories.DataRepository
import com.no1.taiwan.comicbooker.domain.usecases.TestUsecase.Request

class TestUsecase(
    private val repository: DataRepository
) : DeferredUsecase<String, Request>() {
    override suspend fun fetchCase() = requireNotNull(requestValues?.run {
        repository.fetchTest().await()
    })

    class Request(val parameters: BookerParams = BookerParams()) : RequestValues
}
