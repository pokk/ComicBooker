@file:Suppress("NOTHING_TO_INLINE")

package com.no1.taiwan.comicbooker.ext

import com.no1.taiwan.comicbooker.domain.BaseUsecase.RequestValues
import com.no1.taiwan.comicbooker.domain.BookerResponse
import com.no1.taiwan.comicbooker.domain.BookerResponse.Error
import com.no1.taiwan.comicbooker.domain.BookerResponse.Success
import com.no1.taiwan.comicbooker.domain.models.Model
import com.no1.taiwan.comicbooker.entities.Entity
import com.no1.taiwan.comicbooker.entities.mappers.Mapper
import kotlinx.coroutines.Deferred

//region Observable
/**
 * Connected [ObservableUseCase] and unwrapping and letting the usecase become a await
 * [Deferred] object without the mapper (Because the
 * variables should be primitive variable).
 *
 * @param parameter the usecase's parameter.
 */
suspend fun <M : Any, V : RequestValues> ObservableCaseWithResponse<M, V>.toRun(
    parameter: V? = null
) = apply { requestValues = parameter }.execute()

/**
 * Connected [ObservableUseCase] and unwrapping and letting the usecase become a await
 * [Deferred] object with the mapper.
 *
 * @param mapper the mapper for translating from [Model] to [Entity].
 * @param parameter the usecase's parameter.
 */
suspend fun <M : Model, E : Entity, V : RequestValues> ObservableCaseWithResponse<M, V>.toRun(
    mapper: Mapper<M, E>,
    parameter: V? = null
) = apply { requestValues = parameter }.execute().run { mapToEntity(mapper) }

/**
 * Connected [ObservableUseCase] and unwrapping and letting the usecase become a await
 * [Deferred] object. with the mapper.
 *
 * @param mapper the mapper for translating from List<[Model]> to List<[Entity]>.
 * @param parameter the usecase's parameter.
 */
suspend fun <M : Model, E : Entity, V : RequestValues, MS : List<M>> ObservableCaseWithResponse<MS, V>.toRunList(
    mapper: Mapper<M, E>,
    parameter: V? = null
) = apply { requestValues = parameter }.execute().run { mapToEntities(mapper) }
//endregion

/**
 * A mapper which unboxing the [BookerResponse]<[Model]> then getting items we needs. Make a [BookerResponse]
 * again and boxing the [Entity] which mapping from [Model] to [Entity] to be a [BookerResponse]<[Entity]>.
 */
private infix fun <M : Model, E : Entity> BookerResponse<M>.mapToEntity(mapper: Mapper<M, E>) =
    data?.let(mapper::toEntityFrom)?.wrapInSuccess() ?: "No response result".wrapInError<E>()

/**
 * A mapper which unboxing the [BookerResponse]<List<[Model]>> then getting items we needs. Make a [BookerResponse]
 * again and boxing the List<[Entity]> which mapping from List<[Model]> to List<[Entity]> to be a
 * [BookerResponse]<List<[Entity]>>.
 */
private infix fun <M : Model, E : Entity, MS : List<M>> BookerResponse<MS>.mapToEntities(mapper: Mapper<M, E>) =
    data?.map(mapper::toEntityFrom)?.wrapListInSuccess() ?: "No response result".wrapInError<List<E>>()

/**
 * Wrapping the [this] into [Success].
 */
private inline fun <E> E.wrapInSuccess() = Success(this)

/**
 * Wrapping the List<[this]> into [Success].
 */
private inline fun <E, ES : List<E>> ES.wrapListInSuccess() = Success(this)

/**
 * Wrapping the [String] msg into [Error].
 */
private inline fun <E> String.wrapInError() = Error<E>(msg = this)
