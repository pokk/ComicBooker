package com.no1.taiwan.comicbooker.components.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.devrapid.adaptiverecyclerview.AdaptiveAdapter
import com.devrapid.adaptiverecyclerview.AdaptiveViewHolder
import com.devrapid.adaptiverecyclerview.IVisitable

typealias KsViewHolder = AdaptiveViewHolder<MultiTypeFactory, KsMultiVisitable>
typealias KsMultiVisitable = IVisitable<MultiTypeFactory>
typealias KsAdapter = AdaptiveAdapter<MultiTypeFactory, KsMultiVisitable, KsViewHolder>
typealias MultiData = MutableList<KsMultiVisitable>

typealias RVAdapterAny = RecyclerView.Adapter<*>
