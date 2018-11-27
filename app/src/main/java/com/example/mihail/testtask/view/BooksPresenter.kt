package com.example.mihail.testtask.view

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import androidx.paging.PositionalDataSource
import com.example.mihail.testtask.data.BooksDataSource
import com.example.mihail.testtask.entity.Book
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.lang.Exception

class BooksPresenter (private val repository: BooksDataSource) : BasePresenter<BooksView>() {

    fun findBooks(query: String) : LiveData<PagedList<Book>> {

        val factory = object : DataSource.Factory<Int, Book>() {
            override fun create(): DataSource<Int, Book> {
                return object : PositionalDataSource<Book>() {
                    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Book>) {
                        loadBooksInitial(query, params.requestedStartPosition, params.requestedLoadSize, callback)
                    }

                    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Book>) {
                        loadBooksRange(query, params.startPosition, params.loadSize, callback)
                    }
                }
            }
        }

        val config = PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setInitialLoadSizeHint(10)
                .setPageSize(10)
                .build()

        return LivePagedListBuilder(factory, config).build()
    }

    private fun loadBooksRange(query: String, startPosition: Int, limit: Int, callback: PositionalDataSource.LoadRangeCallback<Book>) {
        GlobalScope.launch(Dispatchers.Main) {
            val job = GlobalScope.async {
                repository.volumes(query, startPosition, startPosition)
            }

            try {
                val books = job.await()
                callback.onResult(books.items)
            } catch (e: Exception) {
                view?.showError(e.message.toString())
            }
        }
    }

    private fun loadBooksInitial(query: String, requestedStartPosition: Int, requestedLoadSize: Int, callback: PositionalDataSource.LoadInitialCallback<Book>) {
        GlobalScope.launch(Dispatchers.Main) {
            val job = GlobalScope.async {
                repository.volumes(query, requestedStartPosition, requestedLoadSize)
            }

            try {
                val books = job.await()
                callback.onResult(books.items, requestedStartPosition, books.totalItems)
            } catch (e: Exception) {
                view?.showError(e.message.toString())
            }
        }
    }
}