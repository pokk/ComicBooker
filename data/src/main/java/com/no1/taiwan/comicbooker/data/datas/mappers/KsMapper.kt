package com.no1.taiwan.comicbooker.data.datas.mappers

import com.no1.taiwan.comicbooker.data.datas.BookerData
import com.no1.taiwan.comicbooker.data.datas.DataBookerMapper
import com.no1.taiwan.comicbooker.domain.models.BookerModel
import org.modelmapper.ModelMapper

/**
 * A transforming mapping between [BookerData] and [BookerModel]. The different layers have
 * their own data objects, the objects should transform and fit each layers.
 */
class KsMapper constructor(mapper: ModelMapper) : DataBookerMapper(mapper) {
    override fun toModelFrom(data: BookerData) = mapper.map(data, BookerModel::class.java)

    override fun toDataFrom(model: BookerModel) = mapper.map(model, BookerData::class.java)
}
