package com.example.mihail.testtask

import android.app.Application
import android.content.Context
import com.example.mihail.testtask.di.BooksModule
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.module

class MyApplication : Application() {

    private val appModule = module {
        single<Context>("appContext") { applicationContext }
    }

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(appModule, BooksModule.booksModule))
    }
}