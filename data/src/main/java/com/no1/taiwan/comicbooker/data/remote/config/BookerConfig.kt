package com.no1.taiwan.comicbooker.data.remote.config

/**
 * The configuration of a remote service.
 */
class BookerConfig : ApiConfig {
    companion object {
        const val API_REQUEST = "/remote/v1"
        // All basic http api url of Search Music.
        private const val BASE_URL = "http://192.168.0.5:3000"
    }

    override val apiBaseUrl = BASE_URL
}
