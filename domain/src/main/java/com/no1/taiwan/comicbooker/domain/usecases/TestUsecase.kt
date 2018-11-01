package com.no1.taiwan.comicbooker.domain.usecases

import com.no1.taiwan.comicbooker.domain.DeferredUsecase
import com.no1.taiwan.comicbooker.domain.models.TestModel
import com.no1.taiwan.comicbooker.domain.parameters.BookerParams
import com.no1.taiwan.comicbooker.domain.repositories.DataRepository
import com.no1.taiwan.comicbooker.domain.usecases.TestUsecase.Request
import kotlinx.coroutines.CoroutineScope

class TestUsecase(
    private val repository: DataRepository
) : DeferredUsecase<TestModel, Request>() {
    override fun CoroutineScope.fetchCase() = attachParameter {
        repository.fetchTest(it.parameters, this).await()
    }

    class Request(val parameters: BookerParams = BookerParams()) : RequestValues
}
