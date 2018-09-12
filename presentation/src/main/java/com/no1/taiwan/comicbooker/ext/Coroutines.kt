@file:Suppress("NOTHING_TO_INLINE")

package com.no1.taiwan.comicbooker.ext

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.android.UI
import kotlinx.coroutines.launch

inline fun ui(noinline λ: suspend CoroutineScope.() -> Unit) = launch(UI, block = λ)
