package com.no1.taiwan.comicbooker.domain.usecases

import com.no1.taiwan.comicbooker.domain.DeferredUsecase
import com.no1.taiwan.comicbooker.domain.repositories.DataRepository

class TestUsecase(private val repository: DataRepository) : DeferredUsecase<Boolean, TestUsecase.Request>() {
    override fun fetchCase() = repository.fetchTest()

    class Request : RequestValues
}
