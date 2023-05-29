package com.sample.imagefeaturelibrary.common.data

import android.content.Context
import com.sample.imagefeaturelibrary.R
import com.sample.imagefeaturelibrary.common.data.model.GalleryItem
import com.sample.imagefeaturelibrary.common.util.Constants
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
