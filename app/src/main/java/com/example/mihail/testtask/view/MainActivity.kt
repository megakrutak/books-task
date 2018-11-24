package com.example.mihail.testtask.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.mihail.testtask.R
import com.example.mihail.testtask.data.BooksDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

import org.koin.android.ext.android.inject
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private val repository : BooksDataSource by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch(Dispatchers.Main) {
            val job = GlobalScope.async {
                repository.volumes("android")
            }

            try {

                val books = job.await()

                Log.i("books", books.pizda.toString())
            } catch (e: Exception) {
                throw e
               // Log.i("books", e.toString())
            }

        }
    }
}
