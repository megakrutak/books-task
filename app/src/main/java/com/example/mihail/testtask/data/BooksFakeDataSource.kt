package com.example.mihail.testtask.data

import com.example.mihail.testtask.entity.Book
import com.example.mihail.testtask.entity.BooksList
import com.google.gson.Gson

class BooksFakeDataSource(val jsonReader: JsonReader) : BooksDataSource {

    override suspend fun volumes(q: String): BooksList {
        return Gson().fromJson<BooksList>(jsonReader.readJsonFile("books.json"), BooksList::class.java)
    }

    override suspend fun volumeDetail(id: String): Book {
        return Gson().fromJson<Book>(jsonReader.readJsonFile("book.json"), Book::class.java)
    }
}