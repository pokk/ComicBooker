package com.no1.taiwan.comicbooker.domain.parameters

import com.no1.taiwan.comicbooker.ext.const.DEFAULT_LONG
import com.no1.taiwan.comicbooker.ext.const.DEFAULT_STR
import com.no1.taiwan.comicbooker.ext.const.UniqueId

data class BookerParams(
    val id: UniqueId = DEFAULT_LONG,
    val desc: String = DEFAULT_STR
) : Parameterable {
    companion object {
        const val PARAM_ID = "id"
        const val PARAM_NAME = "name"
    }

    override fun toApiParam() = hashMapOf(
        PARAM_ID to id.toString(),
        PARAM_NAME to desc
    )

    override fun toApiAnyParam() = throw UnsupportedOperationException()
}
