package com.no1.taiwan.comicbooker.internal.di

import android.content.Context
import com.google.gson.FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.no1.taiwan.comicbooker.data.datas.mappers.BookerMapper
import com.no1.taiwan.comicbooker.entities.PresentationBookerMapper
import com.no1.taiwan.comicbooker.entities.mappers.BookerEntityMapper
import org.kodein.di.Kodein.Module
import org.kodein.di.generic.bind
import org.kodein.di.generic.inSet
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.setBinding
import org.kodein.di.generic.singleton
import org.modelmapper.ModelMapper

/**
 * To provide the necessary utility objects for the whole app.
 */
object UtilModule {
    fun utilProvider(context: Context) = Module("Util Module") {
        /** ViewModel Set for [com.no1.taiwan.comicbooker.widget.viewmodel.ViewModelFactory] */
        bind() from setBinding<ViewModelEntry>()
        /** Mapper Set for [com.no1.taiwan.comicbooker.data.datas.mappers.Mapper] */
        bind() from setBinding<DataMapperEntry>()

        bind<ModelMapper>() with instance(ModelMapper())
        bind<Gson>() with singleton {
            with(GsonBuilder()) {
                setFieldNamingPolicy(LOWER_CASE_WITH_UNDERSCORES)
                setLenient()
                create()
            }
        }

        /** Data Layer Mapper */
        bind<DataMapperEntry>().inSet() with provider { BookerMapper::class.java to BookerMapper(instance()) }

        // TODO(jieyi): 2018/09/19 Doing as like the domain can find the mapper.
        /** Presentation Layer Mapper */
        bind<PresentationBookerMapper>() with singleton { BookerEntityMapper(instance()) }
    }
}
