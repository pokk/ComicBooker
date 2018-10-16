package com.no1.taiwan.comicbooker.data.datas.mappers

import com.no1.taiwan.comicbooker.data.datas.BookerData
import com.no1.taiwan.comicbooker.data.datas.DataBookerMapper
import com.no1.taiwan.comicbooker.domain.models.BookerModel

/**
 * A transforming mapping between [BookerData] and [BookerModel]. The different layers have
 * their own data objects, the objects should transform and fit each layers.
 */
class BookerMapper : DataBookerMapper {
    override fun toModelFrom(data: BookerData) = data.run { BookerModel(id, name) }

    override fun toDataFrom(model: BookerModel) = model.run { BookerData(id, name) }
}
