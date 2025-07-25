package com.example.booktracker

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class BookViewModel : ViewModel() {
    private var nextId = 0
    val books = mutableStateListOf<Book>()
    var loggedIn = false

    fun login(username: String, password: String): Boolean {
        if (username == "admin" && password == "1234") {
            loggedIn = true
            return true
        }
        return false
    }

    fun addBook(title: String, author: String, status: String) {
        books.add(Book(nextId++, title, author, status))
    }

    fun getBook(id: Int): Book? = books.find { it.id == id }

    fun updateBook(updated: Book) {
        books.replaceAll { if (it.id == updated.id) updated else it }
    }

    fun deleteBook(id: Int) {
        books.removeAll { it.id == id }
    }
}
