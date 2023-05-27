package com.sample.spaceridegalley.imagedetails.view

import android.util.Log
import com.sample.spaceridegalley.common.data.ImageDataSource
import com.sample.spaceridegalley.util.Constants
import javax.inject.Inject

class ImageDetailUseCaseImpl @Inject constructor(
    private val imageDataSource: ImageDataSource
) : ImageDetailUseCase {
    override suspend fun getImageItemList(): List<DetailItemModel> {
        return imageDataSource.getGalleryItems()
            .filter { it.media_type == Constants.MediaTypeImage }
            .sortedBy { it.date }
            .map {
            DetailItemModel(
                owner = it.copyright,
                date  = it.date,
                explanation = it.explanation,
                hdurl = it.hdurl,
                title = it.title,
            )
        }
    }
}