package com.example.booktracker

data class Book(
    val id: Int,
    val title: String,
    val author: String,
    val status: String // "Por leer", "En progreso", "Terminado"
)
