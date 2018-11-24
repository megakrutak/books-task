package com.example.mihail.testtask.view

import com.example.mihail.testtask.data.BooksDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.lang.Exception

class BooksPresenter(private val repository: BooksDataSource) : BasePresenter<BooksView>() {

    fun findBooks(query: String) {
        view?.showProgress(true)

        GlobalScope.launch(Dispatchers.Main) {
            val job = GlobalScope.async {
                repository.volumes(query)
            }

            try {
                val books = job.await()
                view?.showProgress(false)
                view?.showBooks(books)
            } catch (e: Exception) {
                throw e
                // Log.i("books", e.toString())
            }
        }
    }
}