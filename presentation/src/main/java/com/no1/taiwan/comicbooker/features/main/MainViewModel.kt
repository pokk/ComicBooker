package com.no1.taiwan.comicbooker.features.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.no1.taiwan.comicbooker.domain.usecases.TestUsecase

class MainViewModel(
    private val usecase: TestUsecase
) : ViewModel() {
    val test by lazy { MutableLiveData<Boolean>() }

    suspend fun fetchTest() = usecase.execute(TestUsecase.Request()).await()
}
