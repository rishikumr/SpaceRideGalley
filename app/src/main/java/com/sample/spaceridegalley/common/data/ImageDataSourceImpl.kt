package com.sample.spaceridegalley.common.data

import android.content.Context
import androidx.annotation.RawRes
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sample.spaceridegalley.R
import com.sample.spaceridegalley.common.data.model.GalleryItem
import com.sample.spaceridegalley.common.util.Constants
import javax.inject.Inject

/**
 * This is a data layer class which provides few methods to get all the Gallery Items from static json file
 * */
class ImageDataSourceImpl @Inject constructor(private val appContext: Context) : ImageDataSource {

    /* Raed from static file*/
    override suspend fun getGalleryItems(): List<GalleryItem> {
        return Constants.readRawJson(appContext, R.raw.nasa_details)
    }
}

