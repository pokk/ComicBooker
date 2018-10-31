package com.no1.taiwan.comicbooker.domain.usecases

import com.no1.taiwan.comicbooker.domain.DeferredUsecase
import com.no1.taiwan.comicbooker.domain.models.BookerModel
import com.no1.taiwan.comicbooker.domain.parameters.BookerParams
import com.no1.taiwan.comicbooker.domain.repositories.DataRepository
import com.no1.taiwan.comicbooker.domain.usecases.GetBookersUsecase.Request
import kotlinx.coroutines.Job

class GetBookersUsecase(
    private val repository: DataRepository
) : DeferredUsecase<List<BookerModel>, Request>() {
    override suspend fun fetchCase(parentJob: Job) = attachParameter {
        repository.fetchBooker(it.parameters).await()
    }

    class Request(val parameters: BookerParams = BookerParams()) : RequestValues
}
