package com.no1.taiwan.comicbooker.components.recyclerview

import android.content.Context
import android.view.ViewGroup
import com.no1.taiwan.comicbooker.ext.const.DEFAULT_INT
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

/**
 * The common recyclerview adapter for the multi-type object. Avoid that we create
 * a lots similar boilerplate adapters.
 */
open class MultiTypeAdapter(
    override var dataList: MultiData,
    context: Context
) : KsAdapter(), KodeinAware {
    override var typeFactory: MultiTypeFactory
        get() = multiTypeFactory
        set(_) = throw UnsupportedOperationException("We don't allow this method to use!")
    override val kodein by closestKodein(context)
    protected var viewType = DEFAULT_INT
    private val multiTypeFactory by instance<MultiTypeFactory>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KsViewHolder {
        this.viewType = viewType

        return super.onCreateViewHolder(parent, viewType)
    }
}
