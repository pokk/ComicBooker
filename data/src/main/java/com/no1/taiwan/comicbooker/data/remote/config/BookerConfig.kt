package com.no1.taiwan.comicbooker.data.remote.config

import com.no1.taiwan.comicbooker.data.BuildConfig

/**
 * The configuration of a remote service.
 */
class BookerConfig : ApiConfig {
    companion object {
        const val API_REQUEST = "/remote/v1"
        // All basic http api url of Search Music.
        private const val BASE_URL = BuildConfig.URL_SERVER
    }

    override val apiBaseUrl = BASE_URL
}
