package com.no1.taiwan.comicbooker

import android.content.Context
import androidx.multidex.MultiDexApplication
import com.devrapid.kotlinknifer.SharedPrefs
import com.facebook.stetho.Stetho
import com.no1.taiwan.comicbooker.internal.di.AppModule.appProvider
import com.no1.taiwan.comicbooker.internal.di.RecyclerViewModule.recyclerViewProvider
import com.no1.taiwan.comicbooker.internal.di.RepositoryModule.repositoryProvider
import com.no1.taiwan.comicbooker.internal.di.ServiceModule.serviceProvider
import com.no1.taiwan.comicbooker.internal.di.UtilModule.utilProvider
import com.no1.taiwan.comicbooker.internal.di.dependency.UsecaseModule.usecaseProvider
import org.jetbrains.anko.defaultSharedPreferences
import org.kodein.di.Kodein.Companion.lazy
import org.kodein.di.KodeinAware
import org.kodein.di.android.androidModule

/**
 * Android Main Application
 */
class App : MultiDexApplication(), KodeinAware {
    companion object {
        lateinit var appContext: Context
            private set
    }

    init {
        appContext = this
    }

    /**
     * A Kodein Aware class must be within reach of a Kodein object.
     */
    override val kodein = lazy {
        val app = this@App

        import(androidModule(app))
        /** bindings */
        import(appProvider())
        import(utilProvider(app))
        import(repositoryProvider())
        /** usecases are bind here but the scope is depending on each layers.  */
        import(usecaseProvider())
        import(serviceProvider(app))
        import(recyclerViewProvider(app))
    }

    override fun onCreate() {
        super.onCreate()
        SharedPrefs.setPrefSettings(defaultSharedPreferences)
        Stetho.initialize(Stetho.newInitializerBuilder(this)
                              .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                              .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                              .build())
    }
}
