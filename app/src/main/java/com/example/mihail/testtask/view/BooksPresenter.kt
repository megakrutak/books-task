package com.example.mihail.testtask.view

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.mihail.testtask.data.BooksDataSource
import com.example.mihail.testtask.data.BooksPositionalDataSource
import com.example.mihail.testtask.entity.Book

class BooksPresenter (private val repository: BooksDataSource) : BasePresenter<BooksView>() {

    fun findBooks(query: String) : LiveData<PagedList<Book>> {

        val factory = object : DataSource.Factory<Int, Book>() {
            override fun create(): DataSource<Int, Book> {
                return BooksPositionalDataSource(repository, query)
            }
        }

        val config = PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setInitialLoadSizeHint(10)
                .setPageSize(10)
                .build()

        return LivePagedListBuilder(factory, config).build()
    }
}