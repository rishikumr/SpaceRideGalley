package com.sample.spaceridegalley.common.data

import android.content.Context
import androidx.annotation.RawRes
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sample.spaceridegalley.R
import com.sample.spaceridegalley.common.data.model.GalleryItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class StaticDataSource  @Inject constructor (private val appContext : Context) : ImageDataSource {

    /* Raed from static file*/
    override suspend fun getGalleryItems(): List<GalleryItem> {
        return readRawJson(appContext , R.raw.nasa_details)
    }
}

private inline fun <reified T> readRawJson(appContext: Context, @RawRes rawResId: Int): T {
    appContext.resources.openRawResource(rawResId).bufferedReader().use {
        return Gson().fromJson<T>(it, object: TypeToken<T>() {}.type)
    }
}