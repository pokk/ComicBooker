package com.no1.taiwan.comicbooker.data.datas

import com.no1.taiwan.comicbooker.ext.const.DEFAULT_LONG
import com.no1.taiwan.comicbooker.ext.const.DEFAULT_STR
import com.no1.taiwan.comicbooker.ext.const.UniqueId

data class BookerData(
    val id: UniqueId = DEFAULT_LONG,
    val name: String = DEFAULT_STR
) : Data
