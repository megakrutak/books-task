package com.example.mihail.testtask.data

import awaitObject
import com.example.mihail.testtask.entity.Book
import com.example.mihail.testtask.entity.BooksList
import com.github.kittinunf.fuel.gson.gsonDeserializerOf

class BooksRemoteDataSource (private val apiClient: BooksApiClient) : BooksDataSource {

    override suspend fun volumes(q: String): BooksList {
        return apiClient.get("/volumes", listOf("q" to q)).awaitObject(gsonDeserializerOf())
    }

    override suspend fun volumeDetail(id: String): Book {
        return apiClient.get("/volumes/$id").awaitObject(gsonDeserializerOf())
    }
}
