package com.example.mihail.testtask.data

import com.example.mihail.testtask.entity.Book
import com.example.mihail.testtask.entity.BooksList

interface BooksDataSource {

    suspend fun volumes(q: String): BooksList
    suspend fun volumeDetail(id: String): Book

}
