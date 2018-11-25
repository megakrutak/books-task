package com.example.mihail.testtask.data

import com.example.mihail.testtask.entity.Book
import com.example.mihail.testtask.entity.BooksList

interface BooksDataSource {

    suspend fun volumes(q: String, startIndex: Int = 0, maxResults: Int = 30): BooksList
    suspend fun volumeDetail(id: String): Book

}
