package com.example.mihail.testtask.data

import android.util.Log
import androidx.paging.PositionalDataSource
import com.example.mihail.testtask.entity.Book
import kotlinx.coroutines.*
import java.lang.Exception

class BooksPositionalDataSource (private val repository: BooksDataSource, private val query: String) : PositionalDataSource<Book>() {

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Book>) {
        GlobalScope.launch(Dispatchers.Main) {
            val job = GlobalScope.async {
                repository.volumes(query, params.startPosition, params.loadSize)
            }

            try {
                val books = job.await()
                callback.onResult(books.items)
            } catch (e: Exception) {
                Log.e("error", e.toString())
            }
        }
    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Book>) {
        GlobalScope.launch(Dispatchers.Main) {
            val job = GlobalScope.async {
                repository.volumes(query, params.requestedStartPosition, params.requestedLoadSize)
            }

            try {
                val books = job.await()
                callback.onResult(books.items, params.requestedStartPosition, books.totalItems)
            } catch (e: Exception) {
                Log.e("error", e.toString())
            }
        }
    }
}