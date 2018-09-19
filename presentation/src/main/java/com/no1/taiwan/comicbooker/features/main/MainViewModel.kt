package com.no1.taiwan.comicbooker.features.main

import com.no1.taiwan.comicbooker.components.viewmodel.AutoViewModel
import com.no1.taiwan.comicbooker.domain.usecases.TestUsecase
import com.no1.taiwan.comicbooker.ext.ResponseLiveData
import com.no1.taiwan.comicbooker.ext.requestData
import com.no1.taiwan.comicbooker.ext.toRun

class MainViewModel(
    private val usecase: TestUsecase
) : AutoViewModel() {
    val test by lazy { ResponseLiveData<String>() }

    fun fetchTest() = test requestData { usecase.toRun(TestUsecase.Request()) }
}
