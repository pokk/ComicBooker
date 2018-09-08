package com.no1.taiwan.comicbooker.ext

import androidx.lifecycle.MutableLiveData
import com.no1.taiwan.comicbooker.domain.BookerResponse

typealias ResponseLiveData<D> = MutableLiveData<BookerResponse<D>>
