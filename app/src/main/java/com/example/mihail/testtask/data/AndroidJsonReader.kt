package com.example.mihail.testtask.data

import android.content.Context
import java.io.BufferedReader
import java.io.InputStreamReader

class AndroidJsonReader(private val context: Context) : JsonReader() {

    override fun readJsonFile(jsonFile: String): String {
        val buf = StringBuilder()
        val json = context.assets.open(jsonFile)
        BufferedReader(InputStreamReader(json, "UTF-8"))
                .use {
                    val list = it.lineSequence().toList()
                    buf.append(list.joinToString("\n"))
                }

        return buf.toString()
    }
}