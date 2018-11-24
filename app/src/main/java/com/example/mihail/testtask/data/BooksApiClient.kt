package com.example.mihail.testtask.data

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.Request

class BooksApiClient (private val baseUrl: String)  {

    fun get(url: String, parameters: List<Pair<String, Any?>>? = null) : Request {
        return Fuel.get("$baseUrl/${url.trimStart { it == '/' }}", parameters)
    }
}