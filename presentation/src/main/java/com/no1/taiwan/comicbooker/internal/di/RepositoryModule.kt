package com.no1.taiwan.comicbooker.internal.di

import com.no1.taiwan.comicbooker.data.datas.mappers.MapperPool
import com.no1.taiwan.comicbooker.data.repositories.BookerDataRepository
import com.no1.taiwan.comicbooker.domain.repositories.DataRepository
import com.no1.taiwan.comicbooker.internal.di.tags.KsTag.LOCAL
import com.no1.taiwan.comicbooker.internal.di.tags.KsTag.REMOTE
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

/**
 * To provide the necessary objects into the repository.
 */
object RepositoryModule {
    fun repositoryProvider() = Kodein.Module("Repository Module") {
        //        bind<KsCache>(LOCAL) with singleton { KsMemoryCache() }
//        bind<DataStore>(REMOTE) with singleton { RemoteDataStoreImpl(instance(), instance(), instance()) }
//        bind<DataStore>(LOCAL) with singleton { LocalDataStoreImpl(instance(), instance()) }
        /** Mapper Pool for providing all data mappers */
        bind<MapperPool>() with provider { instance<DataMapperEntries>().toMap() }

        bind<DataRepository>() with singleton {
            BookerDataRepository(instance(LOCAL), instance(LOCAL), instance(REMOTE), instance())
        }
    }
}
