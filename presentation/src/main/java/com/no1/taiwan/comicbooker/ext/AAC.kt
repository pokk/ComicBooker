package com.no1.taiwan.comicbooker.ext

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.no1.taiwan.comicbooker.domain.BookerResponse

/**
 * Observe the [LiveData]'s nullable value from [androidx.lifecycle.ViewModel].
 */
inline fun <reified T> LifecycleOwner.observe(liveData: LiveData<T>, noinline block: (T?.() -> Unit)? = null) =
    block?.let { liveData.observe(this, Observer(it)) }

/**
 * Observe the [LiveData]'s nonnull value from [androidx.lifecycle.ViewModel].
 */
inline fun <reified T> LifecycleOwner.observeNonNull(liveData: LiveData<T>, noinline block: (T.() -> Unit)? = null) =
    block?.run { liveData.observe(this@observeNonNull, Observer { it?.let(this) }) }

/**
 * Observe the [LiveData]'s nullable value which comes from the un-boxed [BookerResponse] value
 * from [androidx.lifecycle.ViewModel].
 */
inline fun <reified E, T : BookerResponse<E>> LifecycleOwner.observeUnbox(
    liveData: LiveData<T>,
    noinline block: (E?.() -> Unit)? = null
) = block?.run { liveData.observe(this@observeUnbox, Observer { it?.data.let(this) }) }

/**
 * Observe the [LiveData]'s nonnull value which comes from the un-boxed [BookerResponse] value
 * from [androidx.lifecycle.ViewModel].
 */
inline fun <reified E, T : BookerResponse<E>> LifecycleOwner.observeUnboxNonNull(
    liveData: LiveData<T>,
    noinline block: (E.() -> Unit)? = null
) = block?.run { liveData.observe(this@observeUnboxNonNull, Observer { it?.data?.let(block) }) }
