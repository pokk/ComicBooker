package com.no1.taiwan.comicbooker.features.main

import androidx.lifecycle.ViewModel
import com.no1.taiwan.comicbooker.domain.BookerResponse
import com.no1.taiwan.comicbooker.domain.BookerResponse.Loading
import com.no1.taiwan.comicbooker.domain.usecases.TestUsecase
import com.no1.taiwan.comicbooker.ext.ResponseLiveData
import kotlinx.coroutines.android.UI
import kotlinx.coroutines.launch

class MainViewModel(
    private val usecase: TestUsecase
) : ViewModel() {
    val test by lazy { ResponseLiveData<Boolean>() }

    fun fetchTest() {
        test.value = Loading()
        launch(UI) {
            test.value = usecase.execute(TestUsecase.Request())
        }
        test.value = BookerResponse.Completed()
    }

    fun abort() {
        usecase.abort()
    }
}
