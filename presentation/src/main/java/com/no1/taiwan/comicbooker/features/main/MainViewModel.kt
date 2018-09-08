package com.no1.taiwan.comicbooker.features.main

import androidx.lifecycle.ViewModel
import com.no1.taiwan.comicbooker.domain.BookerResponse
import com.no1.taiwan.comicbooker.domain.usecases.TestUsecase
import com.no1.taiwan.comicbooker.ext.ResponseLiveData

class MainViewModel(
    private val usecase: TestUsecase
) : ViewModel() {
    val test by lazy { ResponseLiveData<Boolean>() }

    suspend fun fetchTest(): Boolean {
        test.value = BookerResponse.Loading()
        return usecase.execute(TestUsecase.Request()).await()
    }
}
