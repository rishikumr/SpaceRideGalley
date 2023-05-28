package com.sample.spaceridegalley.imagedetails.domain

import com.sample.spaceridegalley.imagedetails.domain.model.DetailItemModel

interface ImageDetailUseCase {
    suspend fun getImageItemList(): List<DetailItemModel>
}
