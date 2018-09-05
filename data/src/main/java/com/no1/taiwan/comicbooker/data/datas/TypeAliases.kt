package com.no1.taiwan.comicbooker.data.datas

import com.no1.taiwan.comicbooker.data.datas.mappers.Mapper

typealias DataMapper = Mapper<*, *>
typealias MapperPool = Map<Class<out DataMapper>, DataMapper>
