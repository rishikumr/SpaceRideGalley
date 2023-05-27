package com.sample.spaceridegalley.imagelist

import com.sample.spaceridegalley.common.data.ImageDataSource
import javax.inject.Inject

class ImageListUseCaseImpl @Inject constructor(
    private val imageDataSource: ImageDataSource
) : ImageListUseCase {
    override suspend fun getImageItemList(): List<ListItemModel> {
        return imageDataSource.getGalleryItems().map {
            ListItemModel(
                lowQUrl = it.url,
                title = it.title
            )
        }
    }
}