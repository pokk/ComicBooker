package com.no1.taiwan.comicbooker.domain.usecases

import com.no1.taiwan.comicbooker.domain.DeferredUsecase
import com.no1.taiwan.comicbooker.domain.models.TestModel
import com.no1.taiwan.comicbooker.domain.parameters.BookerParams
import com.no1.taiwan.comicbooker.domain.repositories.DataRepository
import com.no1.taiwan.comicbooker.domain.usecases.TestUsecase.Request

class TestUsecase(
    private val repository: DataRepository
) : DeferredUsecase<TestModel, Request>() {
    override suspend fun fetchCase() = attachParameter {
        repository.fetchTest(it.parameters).await()
    }

    class Request(val parameters: BookerParams = BookerParams()) : RequestValues
}
