package com.no1.taiwan.comicbooker.ext

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.devrapid.kotlinshaver.isNull
import com.no1.taiwan.comicbooker.bases.LoadView
import com.no1.taiwan.comicbooker.domain.BookerResponse
import com.no1.taiwan.comicbooker.domain.BookerResponse.Error
import com.no1.taiwan.comicbooker.domain.BookerResponse.Loading
import com.no1.taiwan.comicbooker.domain.BookerResponse.Success

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

// === Peel the response ===

/**
 * Check the [BookerResponse]'s changing and do the corresponding reaction.
 */
fun <D> BookerResponse<D>?.peelResponse(
    loadView: LoadView,
    errorBlock: ((String) -> Unit)? = null,
    completedBlock: (() -> Unit)? = null,
    successBlock: ((D) -> Unit)? = null
) = this?.peelResponseOptions(loadView,
                              isShowError = errorBlock.isNull(),
                              completedBlock = completedBlock,
                              errorBlock = errorBlock,
                              successBlock = successBlock)

/**
 * Check the [BookerResponse]'s changing and do the corresponding reaction. For the situation which we need
 * to use multi-requests in the same time.
 */
fun <D> BookerResponse<D>?.peelResponseAndContinue(loadView: LoadView, successBlock: ((D) -> Unit)? = null) =
    this?.peelResponseOptions(loadView, isHideLoading = false, successBlock = successBlock)

/**
 * Check the [BookerResponse]'s changing and do the corresponding reaction without showing the loading view.
 */
fun <D> BookerResponse<D>?.peelResponseSkipLoading(loadView: LoadView, successBlock: ((D) -> Unit)? = null) =
    this?.peelResponseOptions(loadView, false, successBlock = successBlock)

/**
 * Check the [BookerResponse]'s changing and do the corresponding reaction with error block and completed block..
 */
fun <D> BookerResponse<D>?.peelResponseForCompleted(
    loadView: LoadView,
    errorBlock: ((String) -> Unit)? = null,
    completedBlock: (() -> Unit)? = null
) = this?.peelResponseOptions(loadView, errorBlock = errorBlock, completedBlock = completedBlock)

/**
 * Check the [BookerResponse]'s changing and do the corresponding reaction. Here're three data
 * type [Loading], [Success], and [Error].
 *
 * - [Loading] state will show the loading view.
 * - [Success] state will extract the data from the inside class to be used [successBlock].
 * - [Error] state will show the error view and msg to the user. Also, you can use [errorBlock] manually.
 */
private fun <D> BookerResponse<D>.peelResponseOptions(
    loadView: LoadView,
    isShowLoading: Boolean = true,
    isShowError: Boolean = true,
    isHideLoading: Boolean = true,
    errorBlock: ((String) -> Unit)? = null,
    completedBlock: (() -> Unit)? = null,
    successBlock: ((D) -> Unit)? = null
) = also {
    when (it) {
        is Loading<*> -> if (isShowLoading) loadView.showLoading()
        is Success<D> -> {
            it.data?.run { successBlock?.invoke(this) }
            if (isShowLoading && isHideLoading) loadView.hideLoading()

            if (isShowLoading) loadView.hideLoading()
            completedBlock?.invoke()
        }
        is Error<*> -> {
            if (isShowLoading) loadView.hideLoading()
            if (isShowError) loadView.showError(it.msg)
            errorBlock?.invoke(it.msg)
        }
    }
}
