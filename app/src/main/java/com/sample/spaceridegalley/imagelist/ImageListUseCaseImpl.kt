package com.sample.spaceridegalley.imagelist

import com.sample.spaceridegalley.common.data.ImageDataSource
import com.sample.spaceridegalley.util.Constants
import javax.inject.Inject

class ImageListUseCaseImpl @Inject constructor(
    private val imageDataSource: ImageDataSource
) : ImageListUseCase {
    override suspend fun getImageItemList(): List<ListItemModel> {
        return imageDataSource.getGalleryItems()
            .filter { it.media_type == Constants.MediaTypeImage }
            .sortedBy { it.date }  // TODO check it as expected order or need to reverse it
            .map {
                ListItemModel(
                    lowQUrl = it.url,
                    title = it.title
                )
        }
    }
}