package com.no1.taiwan.comicbooker.components.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.devrapid.adaptiverecyclerview.AdaptiveAdapter
import com.devrapid.adaptiverecyclerview.AdaptiveViewHolder
import com.devrapid.adaptiverecyclerview.IVisitable

typealias BookerViewHolder = AdaptiveViewHolder<MultiTypeFactory, BookerMultiVisitable>
typealias BookerMultiVisitable = IVisitable<MultiTypeFactory>
typealias BookerAdapter = AdaptiveAdapter<MultiTypeFactory, BookerMultiVisitable, BookerViewHolder>
typealias MultiData = MutableList<BookerMultiVisitable>

typealias RVAdapterAny = RecyclerView.Adapter<*>
