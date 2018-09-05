package com.no1.taiwan.comicbooker.ext

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority.HIGH
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.engine.DiskCacheStrategy.RESOURCE
import com.bumptech.glide.request.RequestOptions
import com.no1.taiwan.comicbooker.ext.const.DEFAULT_INT
import com.no1.taiwan.comicbooker.ext.const.takeUnlessDefault

fun ImageView.loadByString(str: String, context: Context = gContext(), options: RequestOptions = glideKsOptions()) =
    glideDefault(context, options) { load(str) }

fun ImageView.loadByBitmap(bitmap: Bitmap, context: Context = gContext(), options: RequestOptions = glideKsOptions()) =
    glideDefault(context, options) { load(bitmap) }

fun ImageView.loadByUri(uri: Uri, context: Context = gContext(), options: RequestOptions = glideKsOptions()) =
    glideDefault(context, options) { load(uri) }

fun ImageView.loadByDrawable(
    drawable: Drawable,
    context: Context = gContext(),
    options: RequestOptions = glideKsOptions()
) =
    glideDefault(context, options) { load(drawable) }

fun ImageView.loadByAny(any: Any, context: Context = gContext(), options: RequestOptions = glideKsOptions()) =
    glideDefault(context, options) { load(any) }

fun glideKsOptions(
    @DrawableRes phResource: Int = DEFAULT_INT,
    @DrawableRes erSource: Int = DEFAULT_INT
) =
    RequestOptions().apply {
        centerCrop()
        phResource.takeUnlessDefault(::placeholder)
        erSource.takeUnlessDefault(::error)
        priority(HIGH)
        diskCacheStrategy(RESOURCE)
    }

fun glideObtaineBitmapFrom(
    uri: Uri,
    context: Context = gContext(),
    options: RequestOptions = glideKsOptions()
): Bitmap = glide(context)
    .asBitmap()
    .apply(options)
    .load(uri)
    .submit()
    .get()

fun glideObtaineDrawableFrom(
    uri: Uri,
    context: Context = gContext(),
    options: RequestOptions = glideKsOptions()
): Drawable = glide(context)
    .asDrawable()
    .apply(options)
    .load(uri)
    .submit()
    .get()

private fun ImageView.glideDefault(
    context: Context = gContext(),
    options: RequestOptions = glideKsOptions(),
    block: RequestBuilder<Bitmap>.() -> RequestBuilder<Bitmap>
) = glide(context)
    .asBitmap()
    .apply(options)
    .block()
    .into(this)

private fun glide(context: Context) = Glide.with(context)
