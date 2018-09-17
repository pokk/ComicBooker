package com.no1.taiwan.comicbooker.entities

import com.no1.taiwan.comicbooker.ext.const.DEFAULT_LONG
import com.no1.taiwan.comicbooker.ext.const.DEFAULT_STR
import com.no1.taiwan.comicbooker.ext.const.UniqueId

data class BookerEntity(
    val id: UniqueId = DEFAULT_LONG,
    val name: String = DEFAULT_STR
) : Entity
