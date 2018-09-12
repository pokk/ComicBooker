package com.no1.taiwan.comicbooker.domain

import com.no1.taiwan.comicbooker.domain.BookerResponse.Error
import com.no1.taiwan.comicbooker.domain.BookerResponse.Success
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.IO
import kotlinx.coroutines.async

abstract class DeferredUsecase<T, R : BaseUsecase.RequestValues> : BaseUsecase<R>() {
    suspend fun execute(parameter: R? = null) = run {
        parameter?.let { requestValues = it }

        // Wrapper async again for wrapping the result into [BookerResponse].
        async(IO, parent = parentJob) {
            try {
                Success(fetchCase())
            }
            catch (cancel: CancellationException) {
                cancel.printStackTrace()
                Error<T>(msg = cancel.message.orEmpty())
            }
            catch (exception: Exception) {
                exception.printStackTrace()
                Error<T>(msg = exception.message.orEmpty())
            }
        }.await()
    }

    abstract suspend fun fetchCase(): T
}
