package com.example.mihail.testtask.entity

import kotlinx.serialization.Serializable

@Serializable
data class ImageLinks(
        val smallThumbnail: String,
        val thumbnail: String
)