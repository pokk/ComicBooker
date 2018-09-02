package com.no1.taiwan.comicbooker

import android.content.Context
import androidx.multidex.MultiDexApplication
import org.kodein.di.Kodein.Companion.lazy
import org.kodein.di.KodeinAware

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
//
//        import(androidModule(app))
//        /** bindings */
//        import(appProvider())
//        import(utilProvider(app))
//        import(repositoryProvider())
//        /** usecases are bind here but the scope is depending on each layers.  */
//        import(usecaseProvider())
//        import(serviceProvider(app))
//        import(recyclerViewProvider(app))
    }

}
