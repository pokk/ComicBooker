package com.no1.taiwan.comicbooker.features.main

import com.no1.taiwan.comicbooker.components.viewmodel.AutoViewModel
import com.no1.taiwan.comicbooker.domain.usecases.TestUsecase
import com.no1.taiwan.comicbooker.entities.PresentationTestMapper
import com.no1.taiwan.comicbooker.entities.TestEntity
import com.no1.taiwan.comicbooker.ext.ResponseLiveData
import com.no1.taiwan.comicbooker.ext.requestData
import com.no1.taiwan.comicbooker.ext.toRun

class MainViewModel(
    private val usecase: TestUsecase,
    private val mapper: PresentationTestMapper
) : AutoViewModel() {
    val test by lazy { ResponseLiveData<TestEntity>() }

    fun fetchTest() = test requestData { usecase.toRun(mapper, TestUsecase.Request()) }
}
