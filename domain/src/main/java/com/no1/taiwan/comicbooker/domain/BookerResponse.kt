package com.no1.taiwan.comicbooker.domain

import com.no1.taiwan.comicbooker.domain.BookerResponse.Error
import com.no1.taiwan.comicbooker.domain.BookerResponse.Loading
import com.no1.taiwan.comicbooker.domain.BookerResponse.Success
import com.no1.taiwan.comicbooker.ext.const.DEFAULT_STR

/**
 * The super class response from the data layer. There're three result of the response [Loading],
 * [Success], and [Error] for HTTP result.
 */
sealed class BookerResponse<T> constructor(val data: T? = null) {
    /**
     * A request is still processing from a remote/local service.
     */
    class Loading<T>(data: T? = null) : BookerResponse<T>(data)

    /**
     * A request success getting a result from a remote/local service.
     */
    class Success<T>(data: T? = null) : BookerResponse<T>(data)

    /**
     * A request success in translating getting a result from a remote/local service.
     */
    class Translating<T, R>(data: T? = null, var newData: R? = null) : BookerResponse<T>(data)

    /**
     * A request sent then a remote/local service has happened an error.
     */
    class Error<T>(data: T? = null, val msg: String = DEFAULT_STR) : BookerResponse<T>(data)
}
