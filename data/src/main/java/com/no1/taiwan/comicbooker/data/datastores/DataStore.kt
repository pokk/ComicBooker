package com.no1.taiwan.comicbooker.data.datastores

import com.no1.taiwan.comicbooker.data.datas.BookerData
import com.no1.taiwan.comicbooker.domain.parameters.Parameterable
import kotlinx.coroutines.Deferred

interface DataStore {
    fun retrieveTest(parameters: Parameterable): Deferred<BookerData>
}
