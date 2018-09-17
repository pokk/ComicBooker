package com.no1.taiwan.comicbooker.data.datas

import com.no1.taiwan.comicbooker.data.datas.mappers.Mapper
import com.no1.taiwan.comicbooker.domain.models.BookerModel

typealias DataMapper = Mapper<*, *>
typealias MapperPool = Map<Class<out DataMapper>, DataMapper>

typealias DataBookerMapper = Mapper<BookerData, BookerModel>
