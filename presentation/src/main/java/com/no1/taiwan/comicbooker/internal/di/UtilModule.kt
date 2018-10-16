package com.no1.taiwan.comicbooker.internal.di

import android.content.Context
import com.google.gson.FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.no1.taiwan.comicbooker.data.datas.mappers.BookerMapper
import com.no1.taiwan.comicbooker.data.datas.mappers.TestMapper
import com.no1.taiwan.comicbooker.entities.PresentationBookerMapper
import com.no1.taiwan.comicbooker.entities.PresentationTestMapper
import com.no1.taiwan.comicbooker.entities.mappers.BookerEntityMapper
import com.no1.taiwan.comicbooker.entities.mappers.TestEntityMapper
import org.kodein.di.Kodein.Module
import org.kodein.di.generic.bind
import org.kodein.di.generic.inSet
import org.kodein.di.generic.provider
import org.kodein.di.generic.setBinding
import org.kodein.di.generic.singleton

/**
 * To provide the necessary utility objects for the whole app.
 */
object UtilModule {
    fun utilProvider(context: Context) = Module("Util Module") {
        /** ViewModel Set for [com.no1.taiwan.comicbooker.widget.viewmodel.ViewModelFactory] */
        bind() from setBinding<ViewModelEntry>()
        /** Mapper Set for [com.no1.taiwan.comicbooker.data.datas.mappers.Mapper] */
        bind() from setBinding<DataMapperEntry>()

        // OPTIMIZE(jieyi): 2018/10/16 We might use Gson for mapping data.
        bind<Gson>() with singleton {
            with(GsonBuilder()) {
                setFieldNamingPolicy(LOWER_CASE_WITH_UNDERSCORES)
                setLenient()
                create()
            }
        }

        /** Data Layer Mapper */
        bind<DataMapperEntry>().inSet() with provider { BookerMapper::class.java to BookerMapper() }
        bind<DataMapperEntry>().inSet() with provider { TestMapper::class.java to TestMapper() }

        // TODO(jieyi): 2018/09/19 Doing as like the domain can find the mapper.
        /** Presentation Layer Mapper */
        bind<PresentationBookerMapper>() with singleton { BookerEntityMapper() }
        bind<PresentationTestMapper>() with singleton { TestEntityMapper() }
    }
}
