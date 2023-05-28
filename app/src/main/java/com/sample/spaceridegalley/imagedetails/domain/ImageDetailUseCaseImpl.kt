package com.sample.spaceridegalley.imagedetails.domain

import com.sample.spaceridegalley.common.data.ImageDataSource
import com.sample.spaceridegalley.common.util.Constants
import com.sample.spaceridegalley.imagedetails.domain.model.DetailItemModel
import javax.inject.Inject
/**
 * This is a UseCase layer class for any data manipulation/ business logic needed for ImageDetailFragment UI data
 * */
class ImageDetailUseCaseImpl @Inject constructor(
    private val imageDataSource: ImageDataSource
) : ImageDetailUseCase {
    override suspend fun getImageItemList(): List<DetailItemModel> {
        return imageDataSource.getGalleryItems()
            .filter { it.media_type == Constants.MediaTypeImage }
            .sortedByDescending { it.date }
            .map {
                DetailItemModel(
                    owner = it.copyright,
                    date = it.date,
                    explanation = it.explanation,
                    hdurl = it.hdurl,
                    title = it.title
                )
            }
    }
}
