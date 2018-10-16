package com.no1.taiwan.comicbooker.data.datastores

import com.no1.taiwan.comicbooker.data.datas.BookerData
import com.no1.taiwan.comicbooker.data.datas.TestData
import com.no1.taiwan.comicbooker.domain.parameters.Parameterable
import kotlinx.coroutines.Deferred

interface DataStore {
    fun retrieveTest(parameters: Parameterable): Deferred<TestData>

    fun retrieveBookerData(parameters: Parameterable): Deferred<List<BookerData>>
}
