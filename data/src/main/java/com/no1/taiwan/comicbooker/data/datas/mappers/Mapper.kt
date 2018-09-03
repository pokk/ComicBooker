package com.no1.taiwan.comicbooker.data.datas.mappers

import com.no1.taiwan.comicbooker.data.datas.Data
import com.no1.taiwan.comicbooker.domain.models.Model
import org.modelmapper.ModelMapper

/**
 * The mapper is used to transition the object between [Data] and [Model].
 */
abstract class Mapper<D : Data, M : Model>(protected val mapper: ModelMapper) {
    /**
     * Transition the [Data] object to [Model] object.
     *
     * @param data a [Data] data object.
     * @return the same content's [Model] object.
     */
    abstract fun toModelFrom(data: D): M

    /**
     * Transition the [Data] object to [Model] object.
     *
     * @param model a [Model] data object.
     * @return the same content's [Data] object.
     */
    abstract fun toDataFrom(model: M): D
}
