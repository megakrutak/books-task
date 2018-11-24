package com.example.mihail.testtask.view

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel


abstract class BasePresenter<View> : ViewModel(), LifecycleObserver {

    var view: View? = null

    fun attachView(view: View, viewLifecycle: Lifecycle) {
        this.view = view
        viewLifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun onViewDestroyed() {
        view = null
    }
}