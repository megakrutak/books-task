package com.example.mihail.testtask.data

abstract class JsonReader {
    abstract fun readJsonFile(jsonFile: String): String
}