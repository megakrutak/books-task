package com.example.mihail.testtask.entity

import kotlinx.serialization.*

@Serializable
data class BooksList (
        val kind: String,
        val totalItems: Int,
        val items: List<Book>,
        val pizda: String? = null

)