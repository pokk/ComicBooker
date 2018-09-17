package com.no1.taiwan.comicbooker.internal.di

import android.content.Context
import com.google.gson.FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.kodein.di.Kodein.Module
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
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
//        bind<DataMapperEntry>().inSet() with provider { KsMapper::class.java to KsMapper(instance()) }

        /** Presentation Layer Mapper */
//        bind<PresentationBookerMapper>() with singleton { BookerEntityMapper(instance()) }
    }
}
