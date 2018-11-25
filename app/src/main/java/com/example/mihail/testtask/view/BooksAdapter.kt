package com.example.mihail.testtask.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mihail.testtask.R
import com.example.mihail.testtask.entity.Book
import com.squareup.picasso.Picasso

class BooksAdapter : PagedListAdapter<Book, BookViewHolder>(

        object : DiffUtil.ItemCallback<Book>() {
            override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
                return oldItem.id == newItem.id
            }
        }
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.book_list_item, parent, false)
        return BookViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = getItem(position)
        holder.bookTitle.text = book?.volumeInfo?.title
        Picasso.with(holder.itemView.context)
                .load(book?.volumeInfo?.imageLinks?.smallThumbnail)
                .into(holder.bookImage)
    }

}

class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var bookTitle = itemView.findViewById<TextView>(R.id.bookTitle)
    var bookImage = itemView.findViewById<ImageView>(R.id.bookImg)
}