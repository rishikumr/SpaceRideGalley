package com.sample.spaceridegalley.common.data

import com.sample.spaceridegalley.common.data.model.GalleryItem

interface ImageDataSource{
     suspend fun getGalleryItems() : List<GalleryItem>
}