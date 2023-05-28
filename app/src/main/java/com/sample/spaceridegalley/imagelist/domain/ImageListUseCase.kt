package com.sample.spaceridegalley.imagelist.domain

import com.sample.spaceridegalley.imagelist.domain.model.ListItemModel

interface ImageListUseCase {
    suspend fun getImageItemList(): List<ListItemModel>
}
