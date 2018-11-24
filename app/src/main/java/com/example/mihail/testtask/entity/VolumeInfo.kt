package com.example.mihail.testtask.entity

import kotlinx.serialization.Serializable

@Serializable
data class VolumeInfo(
        val title: String,
        val subtitle: String,
        val description: String,
        val imageLinks: ImageLinks,
        val previewLink: String
)