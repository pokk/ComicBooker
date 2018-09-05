package com.no1.taiwan.comicbooker.bases

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.annotation.UiThread
import androidx.appcompat.app.AppCompatActivity
import com.hwangjr.rxbus.Bus
import com.no1.taiwan.comicbooker.internal.di.dependency.activity.SuperActivityModule.activityModule
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.android.retainedKodein
import org.kodein.di.generic.instance
import org.kodein.di.generic.kcontext

/**
 * The basic activity is for the normal activity which prepares all necessary variables or functions.
 */
abstract class BaseActivity : AppCompatActivity(), KodeinAware {
    override val kodeinContext get() = kcontext(this)
    override val kodein by retainedKodein {
        extend(parentKodein)
        /* activity specific bindings */
        import(activityModule())
    }
    protected val bus by instance<Bus>()
    private val parentKodein by closestKodein()

    //region RxBus Example
    // OPTIMIZE(jieyi): 2018/04/19 This's a simple example for RxBus.
    // Register it in the parent class that it will be not reflected.
    protected var busEvent = object {
//        @Subscribe(tags = [Tag(RxbusTag.NAVIGATOR)])
//        fun test(test: String) { }
    }
    //endregion

    //region Activity lifecycle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        preSetContentView()
        setContentView(provideLayoutId())
        init(savedInstanceState)

        // Register RxBus.
        bus.register(busEvent)
    }

    override fun onDestroy() {
        super.onDestroy()

        // Unregister RxBus.
        bus.unregister(busEvent)
        uninit()
    }
    //endregion

    @UiThread
    protected abstract fun init(savedInstanceState: Bundle?)

    @UiThread
    protected open fun uninit() = Unit

    @UiThread
    protected fun preSetContentView() = Unit

    @LayoutRes
    abstract fun provideLayoutId(): Int
}
