package com.no1.taiwan.comicbooker.components.viewmodel

import androidx.lifecycle.ViewModel
import com.devrapid.kotlinknifer.logw

open class AutoViewModel : ViewModel() {
    /**
     * This method will be called when this ViewModel is no longer used and will be destroyed.
     *
     * It is useful when ViewModel observes some data and you need to clear this subscription to
     * prevent a leak of this ViewModel.
     */
    override fun onCleared() {
        this::class.java.declaredFields.forEach {
            logw(it.type)
        }
    }
}
