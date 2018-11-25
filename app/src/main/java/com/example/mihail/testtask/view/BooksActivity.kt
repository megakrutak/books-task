package com.example.mihail.testtask.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer

import com.example.mihail.testtask.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class BooksActivity : AppCompatActivity(), BooksView {

    private val booksAdapter = BooksAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val presenter: BooksPresenter by viewModel()
        presenter.attachView(this, lifecycle)
        booksRecycler.adapter = booksAdapter

        findButton.setOnClickListener {
            presenter.findBooks(queryEditText.text.toString()).observe(this, Observer { list ->
                booksAdapter.submitList(list)
            })
        }
    }

    override fun showBooks() {

    }

    override fun showProgress(show: Boolean) {

    }
}
