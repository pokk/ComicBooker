package com.no1.taiwan.comicbooker.ext

import com.no1.taiwan.comicbooker.domain.BookerResponse
import com.no1.taiwan.comicbooker.domain.BookerResponse.Error
import com.no1.taiwan.comicbooker.domain.BookerResponse.Loading
import com.no1.taiwan.comicbooker.domain.BookerResponse.Success
import com.no1.taiwan.comicbooker.domain.BookerResponse.Translating
import com.no1.taiwan.comicbooker.entities.Entity
import kotlinx.coroutines.CoroutineScope

/**
 * A transformer wrapper for encapsulating the [ResponseLiveData]'s state
 * changing and the state becomes [Success] when retrieving a data from Data layer by Kotlin coroutine.
 *
 * Also, unboxing the [BookerResponse] and obtaining the data inside of the [BookerResponse], then return the
 * data to [ResponseLiveData].
 */
fun <E : Entity, R> ResponseLiveData<R>.requestData(
    usecaseRes: suspend CoroutineScope.() -> BookerResponse<E>,
    transformBlock: (E) -> R
) = preProcess {
    // Fetching the data from the data layer.
    value = tryResponse {
        val entity = usecaseRes()

        entity.data?.let(transformBlock)?.let { Success(it) } ?: Error<R>(msg = "Don't have any response.")
    }
}

/**
 * A transformer wrapper for encapsulating the [ResponseLiveData]'s state
 * changing and the state becomes [Success] when retrieving a data from Data layer by Kotlin coroutine.
 */
infix fun <E> ResponseLiveData<E>.requestData(usecaseRes: suspend CoroutineScope.() -> BookerResponse<E>) =
    preProcess {
        // Fetching the data from the data layer.
        value = tryResponse { usecaseRes() }
    }

// TODO(jieyi): 2018/09/12 Finish the map extensions.
/**
 * A transformer wrapper for encapsulating the [ResponseLiveData]'s state
 * changing and the state becomes [Success] when retrieving a data from Data layer by Kotlin coroutine.
 */
infix fun <E : Entity> ResponseLiveData<E>.requestDataTo(usecaseRes: suspend CoroutineScope.() -> BookerResponse<E>) =
    preProcess {
        // Fetching the data from the data layer.
        value = Translating<E, Any>(tryResponse { usecaseRes() }.data)
    }

/**
 * Pre-process doing the loading view.
 */
private fun <E> ResponseLiveData<E>.preProcess(block: suspend CoroutineScope.() -> Unit) = apply {
    ui {
        // Opening the loading view.
        value = Loading()
        // Fetching the data from the data layer.
        block()
    }
}

/**
 * Wrapping the `try catch` and ignoring the return value.
 */
private inline fun <E> tryResponse(block: () -> BookerResponse<E>) = try {
    block()
}
catch (e: Exception) {
    e.printStackTrace()
    Error<E>(msg = e.message ?: "Unknown error has happened.")
}
