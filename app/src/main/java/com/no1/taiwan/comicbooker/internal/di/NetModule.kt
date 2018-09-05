package com.no1.taiwan.comicbooker.internal.di

import android.content.Context
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import org.kodein.di.Kodein.Module
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit.Builder
import retrofit2.converter.gson.GsonConverterFactory

/**
 * To provide the necessary object for the internet model.
 */
object NetModule {
    private const val CacheMaxSize = 10 * 1024 * 1024L

    fun netProvider(context: Context) = Module("Net Module") {
        bind<Converter.Factory>() with singleton { GsonConverterFactory.create(instance()) }
        bind<CallAdapter.Factory>() with singleton { CoroutineCallAdapterFactory() }
        bind<Cache>() with singleton { Cache(context.cacheDir, CacheMaxSize /* 10 MiB */) }
        bind<OkHttpClient>() with singleton {
            OkHttpClient.Builder().apply {
                addInterceptor(HttpLoggingInterceptor().setLevel(BODY))
                cache(instance())
            }.build()
        }
        bind<Builder>() with singleton {
            Builder().apply {
                addConverterFactory(instance())
                addCallAdapterFactory(instance())
                client(instance())
            }
        }
    }
}
