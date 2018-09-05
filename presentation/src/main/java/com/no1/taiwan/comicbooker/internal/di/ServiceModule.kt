package com.no1.taiwan.comicbooker.internal.di

import android.content.Context
import com.google.firebase.database.FirebaseDatabase
import com.no1.taiwan.comicbooker.data.local.services.BookerDatabase
import com.no1.taiwan.comicbooker.data.local.v1.BookerRoom
import com.no1.taiwan.comicbooker.data.remote.RestfulApiFactory
import com.no1.taiwan.comicbooker.data.remote.config.BookerConfig
import com.no1.taiwan.comicbooker.data.remote.services.BookerService
import com.no1.taiwan.comicbooker.internal.di.NetModule.netProvider
import org.kodein.di.Kodein.Module
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton
import retrofit2.Retrofit

/**
 * To provide the necessary objects for the remote/local data store service.
 */
object ServiceModule {
    fun serviceProvider(context: Context) = Module("RESTFul Service Module") {
        // *** For the [Remote] data module.
        import(netProvider(context))
        import(firebaseProvider())

        import(implementationRemoteProvider())

        // *** For the [Local] data module.
//        import(tensorFlowProvider(context))

        import(implementationLocalProvider())
    }

    //region Remote Providers
    /**
     * To provide the necessary objects Remote Implementation objects into the repository.
     */
    private fun implementationRemoteProvider() = Module("Implementation Remote Module") {
        bind<BookerConfig>() with instance(RestfulApiFactory().createKsConfig())
        bind<BookerService>() with singleton {
            with(instance<Retrofit.Builder>()) {
                baseUrl(instance<BookerConfig>().apiBaseUrl)
                build()
            }.create(BookerService::class.java)
        }
//        bind<BookerFirebase>() with singleton { KsFirebaseImpl(instance(), instance()) }
    }

    /**
     * To provide the necessary objects [FirebaseDatabase] into the repository.
     */
    private fun firebaseProvider() = Module("Firebase Module") {
        bind<FirebaseDatabase>() with provider { FirebaseDatabase.getInstance() }
    }
    //endregion

    /**
     * To provide the necessary objects Local Implementation objects into the repository.
     */
    private fun implementationLocalProvider() = Module("Implementation Local Module") {
        bind<BookerDatabase>() with instance(BookerRoom())
    }
}