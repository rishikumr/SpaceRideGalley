package com.sample.imagefeaturelibrary.imagedetails.domain

import com.sample.imagefeaturelibrary.imagedetails.domain.model.DetailItemModel

interface ImageDetailUseCase {
    suspend fun getImageItemList(): List<DetailItemModel>
}
