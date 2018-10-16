package com.no1.taiwan.comicbooker.entities.mappers

import com.no1.taiwan.comicbooker.domain.models.BookerModel
import com.no1.taiwan.comicbooker.entities.BookerEntity
import com.no1.taiwan.comicbooker.entities.PresentationBookerMapper

/**
 * A transforming mapping between [BookerModel] and [BookerEntity]. The different layers have
 * their own data objects, the objects should transform and fit each layers.
 */
class BookerEntityMapper : PresentationBookerMapper {
    override fun toEntityFrom(model: BookerModel) = model.run { BookerEntity(id, name) }

    override fun toModelFrom(entity: BookerEntity) = entity.run { BookerModel(id, name) }
}
