package com.no1.taiwan.comicbooker.features.main

import com.devrapid.kotlinknifer.logd
import com.devrapid.kotlinknifer.logw
import com.no1.taiwan.comicbooker.components.viewmodel.AutoViewModel
import com.no1.taiwan.comicbooker.domain.DeferredUsecase
import com.no1.taiwan.comicbooker.domain.usecases.TestUsecase
import com.no1.taiwan.comicbooker.ext.ResponseLiveData
import com.no1.taiwan.comicbooker.ext.requestData
import com.no1.taiwan.comicbooker.ext.toRun

class MainViewModel(
    private val usecase: TestUsecase
) : AutoViewModel() {
    val test by lazy { ResponseLiveData<String>() }

    fun fetchTest() = test requestData {
        this@MainViewModel::class.java.declaredFields.forEach {
            logw(it.type.superclass)
            logw(it.type.superclass == DeferredUsecase::class.java)
            logw(it.type.superclass)
            if (it.type.superclass == DeferredUsecase::class.java) {
                val m = it.type.superclass?.superclass?.getMethod("abort")
                logd(it.type.superclass.superclass)
                // TODO(jieyi): 2018/09/13 get the each objects.
                m?.invoke(usecase)  // ⇐ usecase
            }
        }
        usecase.toRun()
    }
}
