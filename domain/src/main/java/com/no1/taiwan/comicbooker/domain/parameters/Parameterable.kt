package com.no1.taiwan.comicbooker.domain.parameters

import com.no1.taiwan.comicbooker.domain.AnyParameters
import com.no1.taiwan.comicbooker.domain.Parameters

/**
 * The interface fo a data class's variables changes to the [HashMap].
 */
interface Parameterable {
    fun toApiParam(): Parameters
    fun toApiAnyParam(): AnyParameters
}
