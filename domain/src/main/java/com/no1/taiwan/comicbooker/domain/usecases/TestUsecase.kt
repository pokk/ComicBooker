package com.no1.taiwan.comicbooker.domain.usecases

import com.no1.taiwan.comicbooker.domain.BaseUsecase
import com.no1.taiwan.comicbooker.domain.BookerResponse
import com.no1.taiwan.comicbooker.domain.BookerResponse.Error
import com.no1.taiwan.comicbooker.domain.BookerResponse.Success
import com.no1.taiwan.comicbooker.domain.DeferredUsecase
import com.no1.taiwan.comicbooker.domain.repositories.DataRepository
import com.no1.taiwan.comicbooker.domain.usecases.TestUsecase.Request

class TestUsecase(
    private val repository: DataRepository
) : DeferredUsecase<BookerResponse<Boolean>, Request>() {
    override suspend fun fetchCase() = try {
        Success(repository.fetchTest().await())
    }
    catch (e: Exception) {
        Error<Boolean>(msg = e.message.orEmpty())
    }

    class Request : BaseUsecase.RequestValues
}
