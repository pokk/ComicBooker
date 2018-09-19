package com.no1.taiwan.comicbooker.features.main

import com.no1.taiwan.comicbooker.components.viewmodel.AutoViewModel
import com.no1.taiwan.comicbooker.domain.usecases.TestUsecase
import com.no1.taiwan.comicbooker.entities.BookerEntity
import com.no1.taiwan.comicbooker.entities.PresentationBookerMapper
import com.no1.taiwan.comicbooker.ext.ResponseLiveData
import com.no1.taiwan.comicbooker.ext.requestData
import com.no1.taiwan.comicbooker.ext.toRun

class MainViewModel(
    private val usecase: TestUsecase,
    private val mapper: PresentationBookerMapper
) : AutoViewModel() {
    val test by lazy { ResponseLiveData<BookerEntity>() }

    fun fetchTest() = test requestData { usecase.toRun(mapper, TestUsecase.Request()) }
}
