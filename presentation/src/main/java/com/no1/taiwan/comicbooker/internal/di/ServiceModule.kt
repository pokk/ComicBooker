package com.no1.taiwan.comicbooker.internal.di

import android.content.Context
import com.no1.taiwan.comicbooker.internal.di.NetModule.netProvider
import org.kodein.di.Kodein.Module

/**
 * To provide the necessary objects for the remote/local data store service.
 */
object ServiceModule {
    fun serviceProvider(context: Context) = Module("RESTFul Service Module") {
        //region For the [Remote] data module.
        import(netProvider(context))
//        import(firebaseProvider())
//        import(cloudinaryProvider())

//        // TODO(jieyi): 2018/08/06 This ks service might be separated.
//        bind<KsConfig>() with instance(RestfulApiFactory().createKsConfig())
//        bind<KsService>() with singleton {
//            with(instance<Retrofit.Builder>()) {
//                baseUrl(instance<KsConfig>().apiBaseUrl)
//                build()
//            }.create(KsService::class.java)
//        }
//
//        bind<KsFirebase>() with singleton { KsFirebaseImpl(instance(), instance()) }
//
//        bind<KsCloudinary>() with singleton { KsCloudinaryImpl(instance()) }
//        //endregion
//
//        //region For the [Local] data module.
//        import(tensorFlowProvider(context))
//
//        bind<KsDatabase>() with instance(KsDbFlowImpl())
//        bind<KsFlow>() with singleton { KsFlowImpl(instance(ML_LABEL)) }
//        //endregion
//    }
//
//    //region Remote Providers
//    /**
//     * To provide the necessary objects [FirebaseDatabase] into the repository.
//     */
//    private fun firebaseProvider() = Module("Firebase Module") {
//        bind<FirebaseDatabase>() with provider { FirebaseDatabase.getInstance() }
//        bind<FirebaseVisionLabelDetector>() with provider { FirebaseVision.getInstance().visionLabelDetector }
//    }
//
//    /**
//     * To provide the necessary objects [MediaManager] into the repository.
//     */
//    private fun cloudinaryProvider() = Module("Cloudinary Module") {
//        bind<MediaManager>() with provider { MediaManager.get() }
//    }
        //endregion
    }
}
