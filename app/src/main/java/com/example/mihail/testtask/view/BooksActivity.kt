package com.example.mihail.testtask.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mihail.testtask.R
import com.example.mihail.testtask.entity.BooksList
import org.koin.androidx.viewmodel.ext.android.viewModel

class BooksActivity : AppCompatActivity(), BooksView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val presenter: BooksPresenter by viewModel()
        presenter.attachView(this, lifecycle)
    }

    override fun showBooks(books: BooksList) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showProgress(show: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
