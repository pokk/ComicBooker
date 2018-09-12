package com.no1.taiwan.comicbooker.ext

import androidx.lifecycle.MutableLiveData
import com.no1.taiwan.comicbooker.domain.BookerResponse
import com.no1.taiwan.comicbooker.domain.DeferredUsecase

typealias ResponseLiveData<D> = MutableLiveData<BookerResponse<D>>

typealias ObservableCaseWithResponse<D, V> = DeferredUsecase<D, V>
typealias SingleCaseWithResponse<D, V> = DeferredUsecase<D, V>
