package com.sample.imagefeaturelibrary.imagelist.domain

import com.sample.imagefeaturelibrary.imagelist.domain.model.ListItemModel

interface ImageListUseCase {
    suspend fun getImageItemList(): List<ListItemModel>
}
