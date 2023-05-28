package com.sample.spaceridegalley.imagelist.domain

import com.sample.spaceridegalley.common.data.ImageDataSource
import com.sample.spaceridegalley.common.util.Constants
import com.sample.spaceridegalley.imagelist.domain.model.ListItemModel
import javax.inject.Inject

class ImageListUseCaseImpl @Inject constructor(
    private val imageDataSource: ImageDataSource
) : ImageListUseCase {
    override suspend fun getImageItemList(): List<ListItemModel> {
        return imageDataSource.getGalleryItems()
            .filter { it.media_type == Constants.MediaTypeImage }
            .sortedByDescending { it.date }
            .map {
                ListItemModel(
                    lowQUrl = it.url,
                    title = it.title
                )
            }
    }
}
