package com.no1.taiwan.comicbooker.entities

import com.no1.taiwan.comicbooker.domain.models.BookerModel
import com.no1.taiwan.comicbooker.domain.models.TestModel
import com.no1.taiwan.comicbooker.entities.mappers.Mapper

typealias PresentationTestMapper = Mapper<TestModel, TestEntity>
typealias PresentationBookerMapper = Mapper<BookerModel, BookerEntity>
