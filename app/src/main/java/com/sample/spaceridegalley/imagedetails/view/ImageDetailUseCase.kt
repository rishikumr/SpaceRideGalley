package com.sample.spaceridegalley.imagedetails.view

interface ImageDetailUseCase {
    suspend fun getImageItemList() : List<DetailItemModel>
}