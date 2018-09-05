package com.no1.taiwan.comicbooker.internal.di.dependency.activity

import org.kodein.di.Kodein.Module

/**
 * To provide the necessary objects for the specific activities.
 */
object SuperActivityModule {
    fun activityModule() = Module("All Activities Module") {
        // Import all of the activity modules.
    }
}
