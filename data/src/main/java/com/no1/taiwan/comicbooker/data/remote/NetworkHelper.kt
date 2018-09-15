package com.no1.taiwan.comicbooker.data.remote

import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager
import com.devrapid.kotlinshaver.cast

fun hasNetwork(context: Context): Boolean? {
    var isConnected = false // Initial Value
    val connectivityManager = cast<ConnectivityManager>(context.getSystemService(CONNECTIVITY_SERVICE))
    val activeNetwork = connectivityManager.activeNetworkInfo
    if (activeNetwork != null && activeNetwork.isConnected)
        isConnected = true
    return isConnected
}
