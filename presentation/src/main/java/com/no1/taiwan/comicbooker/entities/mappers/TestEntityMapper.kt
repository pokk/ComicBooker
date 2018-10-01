package com.no1.taiwan.comicbooker.entities.mappers

import com.no1.taiwan.comicbooker.domain.models.TestModel
import com.no1.taiwan.comicbooker.entities.PresentationTestMapper
import com.no1.taiwan.comicbooker.entities.TestEntity
import org.modelmapper.ModelMapper

/**
 * A transforming mapping between [TestModel] and [TestEntity]. The different layers have
 * their own data objects, the objects should transform and fit each layers.
 */
class TestEntityMapper(mapper: ModelMapper) : PresentationTestMapper(mapper) {
    override fun toEntityFrom(model: TestModel) = model.run {
        TestEntity(items.map { item ->
            TestEntity.ItemEntity(item.id,
                                  item.itemState,
                                  item.itemStateName,
                                  item.planId,
                                  item.planName,
                                  item.brandId,
                                  item.brandName,
                                  item.brandKana,
                                  item.name,
                                  item.sex,
                                  item.priorityReserveItemId,
                                  item.partnershipCompanyId,
                                  item.favorite,
                                  item.imageFile.map {
                                      TestEntity.ImageFileEntity(it.url, it.thumbUrl, it.largeUrl)
                                  })
        }, quantity, res)
    }

    override fun toModelFrom(entity: TestEntity) = mapper.map(entity, TestModel::class.java)
}
