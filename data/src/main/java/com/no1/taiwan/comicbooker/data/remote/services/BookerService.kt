package com.no1.taiwan.comicbooker.data.remote.services

import com.no1.taiwan.comicbooker.data.remote.config.BookerConfig.Companion.API_REQUEST
import com.no1.taiwan.comicbooker.domain.Parameters
import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.GET
import retrofit2.http.QueryMap

/**
 * Thru [retrofit2.Retrofit] we can just define the interfaces which we want to access for.
 */
interface BookerService {
    //region Fake
    @GET("$API_REQUEST/test/api")
    fun retrieveTest(@QueryMap params: Parameters): Deferred<Boolean>
    //endregion
}
