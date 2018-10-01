package com.no1.taiwan.comicbooker.data.datas

import com.no1.taiwan.comicbooker.data.datas.mappers.Mapper
import com.no1.taiwan.comicbooker.domain.models.BookerModel
import com.no1.taiwan.comicbooker.domain.models.TestModel

typealias DataMapper = Mapper<*, *>
typealias MapperPool = Map<Class<out DataMapper>, DataMapper>

typealias DataTestMapper = Mapper<TestData, TestModel>
typealias DataBookerMapper = Mapper<BookerData, BookerModel>
