package com.sample.spaceridegalley.common.data.model


/**
 * This is a UI data model class which is used to parse data from given static json file
 * */
data class GalleryItem(
    val copyright: String,
    val date: String,
    val explanation: String,
    val hdurl: String,
    val media_type: String,
    val service_version: String,
    val title: String,
    val url: String
)
