package com.no1.taiwan.comicbooker.domain.usecases

import com.devrapid.kotlinshaver.threadName
import com.no1.taiwan.comicbooker.domain.BaseUsecase
import com.no1.taiwan.comicbooker.domain.BookerResponse
import com.no1.taiwan.comicbooker.domain.BookerResponse.Error
import com.no1.taiwan.comicbooker.domain.BookerResponse.Success
import com.no1.taiwan.comicbooker.domain.DeferredUsecase
import com.no1.taiwan.comicbooker.domain.repositories.DataRepository
import com.no1.taiwan.comicbooker.domain.usecases.TestUsecase.Request
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.delay

class TestUsecase(
    private val repository: DataRepository
) : DeferredUsecase<BookerResponse<Boolean>, Request>() {
    override suspend fun fetchCase() =
        async(IO, parent = parentJob) {
            try {
                delay(4000L)
                println(threadName())
                Success(repository.fetchTest().await())
            }
            catch (cancel: CancellationException) {
                println("---------------cancel-----------------")
                Error<Boolean>(msg = cancel.message.orEmpty())
            }
            catch (e: Exception) {
                Error<Boolean>(msg = e.message.orEmpty())
            }
        }.await()

    class Request : BaseUsecase.RequestValues
}
