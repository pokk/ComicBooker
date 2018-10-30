package com.no1.taiwan.comicbooker.domain

import com.no1.taiwan.comicbooker.domain.BookerResponse.Error
import com.no1.taiwan.comicbooker.domain.BookerResponse.Success
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

abstract class DeferredUsecase<T : Any, R : BaseUsecase.RequestValues> : BaseUsecase<R>() {
    suspend fun execute(parameter: R? = null) = run {
        parameter?.let { requestValues = it }

        // Wrapper async again for wrapping the result into [BookerResponse].
        try {
            // If the parent job was cancelled that will happened an exception, that's
            // why we should create a new job instead.
            if (parentJob.isCancelled)
                parentJob = Job()

            GlobalScope.async(IO + parentJob) { Success(fetchCase()) }.await()
        }
        catch (cancel: CancellationException) {
            cancel.printStackTrace()
            Error<T>(msg = cancel.message.orEmpty())
        }
        catch (exception: Exception) {
            exception.printStackTrace()
            Error<T>(msg = exception.message.orEmpty())
        }
    }

    abstract suspend fun fetchCase(): T

    protected fun attachParameter(λ: suspend (R) -> T) = runBlocking { requireNotNull(requestValues?.run { λ(this) }) }
}
