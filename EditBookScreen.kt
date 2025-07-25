package com.example.booktracker.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.booktracker.Book
import com.example.booktracker.BookViewModel

@Composable
fun EditBookScreen(navController: NavController, viewModel: BookViewModel, bookId: Int) {
    val book = viewModel.getBook(bookId) ?: return
    var title by remember { mutableStateOf(book.title) }
    var author by remember { mutableStateOf(book.author) }
    var status by remember { mutableStateOf(book.status) }

    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Text("Editar Libro", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(16.dp))

        OutlinedTextField(value = title, onValueChange = { title = it }, label = { Text("Título") })
        OutlinedTextField(value = author, onValueChange = { author = it }, label = { Text("Autor") })

        DropdownMenuStatus(status) { status = it }

        Spacer(Modifier.height(16.dp))
        Button(onClick = {
            viewModel.updateBook(Book(bookId, title, author, status))
            navController.popBackStack()
        }) {
            Text("Actualizar")
        }
    }
}
