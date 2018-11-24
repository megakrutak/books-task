package com.example.mihail.testtask.view

import com.example.mihail.testtask.entity.BooksList

interface BooksView {

    fun showBooks(books: BooksList)

    fun showProgress(show: Boolean)
}