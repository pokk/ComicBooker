package com.no1.taiwan.comicbooker.internal.di

import com.no1.taiwan.comicbooker.data.datas.MapperPool
import com.no1.taiwan.comicbooker.data.datastores.DataStore
import com.no1.taiwan.comicbooker.data.datastores.LocalDataStore
import com.no1.taiwan.comicbooker.data.datastores.RemoteDataStore
import com.no1.taiwan.comicbooker.data.local.cache.AbsCache
import com.no1.taiwan.comicbooker.data.local.cache.BookerMemoryCache
import com.no1.taiwan.comicbooker.data.repositories.BookerDataRepository
import com.no1.taiwan.comicbooker.domain.repositories.DataRepository
import com.no1.taiwan.comicbooker.internal.di.tags.KsTag.LOCAL
import com.no1.taiwan.comicbooker.internal.di.tags.KsTag.REMOTE
import org.kodein.di.Kodein.Module
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

/**
 * To provide the necessary objects into the repository.
 */
object RepositoryModule {
    fun repositoryProvider() = Module("Repository Module") {
        bind<AbsCache>(LOCAL) with singleton { BookerMemoryCache() }
        bind<DataStore>(REMOTE) with singleton { RemoteDataStore(instance(), instance()) }
        bind<DataStore>(LOCAL) with singleton { LocalDataStore(instance()) }
        /** Mapper Pool for providing all data mappers */
        bind<MapperPool>() with provider { instance<DataMapperEntries>().toMap() }

        bind<DataRepository>() with singleton {
            BookerDataRepository(instance(LOCAL), instance(LOCAL), instance(REMOTE), instance())
        }
    }
}
