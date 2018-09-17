package com.no1.taiwan.comicbooker.data.remote

import com.no1.taiwan.comicbooker.data.remote.config.BookerConfig

/**
 * Factory that creates different implementations of [com.no1.taiwan.comicbooker.data.remote.config.ApiConfig].
 */
class RestfulApiFactory {
    fun createBookerConfig() = BookerConfig()
}
