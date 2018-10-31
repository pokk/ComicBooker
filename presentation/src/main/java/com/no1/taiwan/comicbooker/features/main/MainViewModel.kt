package com.no1.taiwan.comicbooker.features.main

import com.no1.taiwan.comicbooker.components.viewmodel.AutoViewModel
import com.no1.taiwan.comicbooker.domain.usecases.TestUsecase
import com.no1.taiwan.comicbooker.entities.PresentationBookerMapper
import com.no1.taiwan.comicbooker.entities.PresentationTestMapper
import com.no1.taiwan.comicbooker.entities.TestEntity
import com.no1.taiwan.comicbooker.ext.ResponseLiveData
import com.no1.taiwan.comicbooker.ext.requestData
import com.no1.taiwan.comicbooker.ext.toRun

class MainViewModel(
    private val usecase: TestUsecase,
//    private val usecase2: GetBookersUsecase,
    private val mapper: PresentationTestMapper,
    private val mapper2: PresentationBookerMapper
) : AutoViewModel() {
    val test by lazy { ResponseLiveData<TestEntity>() }
//    val bookers by lazy { ResponseLiveData<List<BookerEntity>>() }

    fun fetchTest() = test requestData { usecase.toRun(mapper, TestUsecase.Request()) }

    fun fetchBooker() = Unit
//        bookers requestData { usecase2.toRunList(mapper2, GetBookersUsecase.Request()) }
}
