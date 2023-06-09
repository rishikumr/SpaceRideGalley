package com.sample.imagefeaturelibrary.imagelist.domain

import com.sample.imagefeaturelibrary.common.data.ImageDataSource
import com.sample.imagefeaturelibrary.common.util.Constants
import com.sample.imagefeaturelibrary.imagelist.domain.model.ListItemModel
import javax.inject.Inject

/**
 * This is a UseCase layer class for any data manipulation/ business logic needed for ImageListFragment UI data
 * */
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
