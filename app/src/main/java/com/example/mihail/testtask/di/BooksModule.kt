package com.example.mihail.testtask.di

import com.example.mihail.testtask.data.*
import org.koin.dsl.module.module

object BooksModule {

    val booksModule = module {
        single { BooksApiClient("https://www.googleapis.com/books/v1") }

        single<BooksDataSource> { BooksRemoteDataSource(get()) }

        /*single<JsonReader> { AndroidJsonReader(get("appContext")) }
        single<BooksDataSource> { BooksFakeDataSource(get()) }*/
    }
}