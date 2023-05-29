package com.sample.imagefeaturelibrary.common.data

import com.sample.imagefeaturelibrary.common.data.model.GalleryItem

interface ImageDataSource {
    suspend fun getGalleryItems(): List<GalleryItem>
}
