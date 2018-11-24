package com.example.mihail.testtask.entity

import kotlinx.serialization.Serializable

@Serializable
data class Book(
        val kind: String,
        val id: String,
        val selfLink: String,
        val volumeInfo: VolumeInfo
)