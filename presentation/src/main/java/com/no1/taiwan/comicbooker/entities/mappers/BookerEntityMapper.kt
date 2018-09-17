package com.no1.taiwan.comicbooker.entities.mappers

import com.no1.taiwan.comicbooker.domain.models.BookerModel
import com.no1.taiwan.comicbooker.entities.BookerEntity
import com.no1.taiwan.comicbooker.entities.PresentationBookerMapper
import org.modelmapper.ModelMapper

/**
 * A transforming mapping between [BookerModel] and [BookerEntity]. The different layers have
 * their own data objects, the objects should transform and fit each layers.
 */
class BookerEntityMapper(mapper: ModelMapper) : PresentationBookerMapper(mapper) {
    override fun toEntityFrom(model: BookerModel) = mapper.map(model, BookerEntity::class.java)

    override fun toModelFrom(entity: BookerEntity) = mapper.map(entity, BookerModel::class.java)
}
