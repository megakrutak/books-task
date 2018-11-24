package com.example.mihail.testtask.di

import com.example.mihail.testtask.data.*
import com.example.mihail.testtask.view.BooksPresenter
import org.koin.dsl.module.module
import org.koin.androidx.viewmodel.ext.koin.viewModel

object BooksModule {

    val booksModule = module {
        single { BooksApiClient("https://www.googleapis.com/books/v1") }

        single<BooksDataSource> { BooksRemoteDataSource(get()) }

        /*single<JsonReader> { AndroidJsonReader(get("appContext")) }
        single<BooksDataSource> { BooksFakeDataSource(get()) }*/

        viewModel {
            BooksPresenter(get())
        }
    }
}