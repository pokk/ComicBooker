package com.no1.taiwan.comicbooker.data.remote.services

import com.no1.taiwan.comicbooker.domain.Parameters
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.QueryMap

/**
 * Thru [retrofit2.Retrofit] we can just define the interfaces which we want to access for.
 */
interface BookerService {
    //region Fake
//    @GET("$API_REQUEST/test/api")
    @GET("/api/v1/item/list?page=1&limit=20&partnership_company_id=1019")
    fun retrieveTest(@QueryMap params: Parameters): Deferred<Boolean>
    //endregion
}
