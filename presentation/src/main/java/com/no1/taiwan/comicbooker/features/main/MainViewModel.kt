package com.no1.taiwan.comicbooker.features.main

import androidx.lifecycle.ViewModel
import com.no1.taiwan.comicbooker.domain.usecases.TestUsecase
import com.no1.taiwan.comicbooker.ext.ResponseLiveData
import com.no1.taiwan.comicbooker.ext.requestData
import com.no1.taiwan.comicbooker.ext.toRun

class MainViewModel(
    private val usecase: TestUsecase
) : ViewModel() {
    val test by lazy { ResponseLiveData<Boolean>() }

    fun fetchTest() = test requestData { usecase.toRun() }

    fun abort() = usecase.abort()
}
