package com.no1.taiwan.comicbooker.features.main

import androidx.lifecycle.ViewModel
import com.devrapid.kotlinknifer.ui
import com.no1.taiwan.comicbooker.domain.BookerResponse.Loading
import com.no1.taiwan.comicbooker.domain.usecases.TestUsecase
import com.no1.taiwan.comicbooker.ext.ResponseLiveData

class MainViewModel(
    private val usecase: TestUsecase
) : ViewModel() {
    val test by lazy { ResponseLiveData<Boolean>() }

    fun fetchTest() {
        ui {
            test.value = Loading()
            test.value = usecase.execute(TestUsecase.Request())
        }
    }
}
