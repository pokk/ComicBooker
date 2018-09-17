package com.no1.taiwan.comicbooker.domain.models

import com.no1.taiwan.comicbooker.ext.const.DEFAULT_LONG
import com.no1.taiwan.comicbooker.ext.const.DEFAULT_STR
import com.no1.taiwan.comicbooker.ext.const.UniqueId

/**
 * Model object in domain layer to be a bridge object.
 */
data class BookerModel(
    val id: UniqueId = DEFAULT_LONG,
    val name: String = DEFAULT_STR
) : Model
