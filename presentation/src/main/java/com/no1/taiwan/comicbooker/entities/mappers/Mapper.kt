package com.no1.taiwan.comicbooker.entities.mappers

import com.no1.taiwan.comicbooker.domain.models.Model
import com.no1.taiwan.comicbooker.entities.Entity
import org.modelmapper.ModelMapper

/**
 * The mapper is used to transition the object between [Model] and [Entity].
 */
abstract class Mapper<M : Model, E : Entity>(protected val mapper: ModelMapper) {
    /**
     * Transition the [Model] object to [Entity] object.
     *
     * @param model a [Model] model object.
     * @return the same content's [Entity] object.
     */
    abstract fun toEntityFrom(model: M): E

    /**
     * Transition the [Model] object to [Entity] object.
     *
     * @param entity a [Entity] data object.
     * @return the same content's [Model] object.
     */
    abstract fun toModelFrom(entity: E): M
}
