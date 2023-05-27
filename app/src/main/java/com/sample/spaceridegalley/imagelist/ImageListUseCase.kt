package com.sample.spaceridegalley.imagelist

interface ImageListUseCase {
    suspend fun getImageItemList() : List<ListItemModel>
}