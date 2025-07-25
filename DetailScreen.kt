package com.example.booktracker.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.booktracker.BookViewModel

@Composable
fun DetailScreen(navController: NavController, viewModel: BookViewModel, bookId: Int) {
    val book = viewModel.getBook(bookId) ?: return

    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Text("Detalle del Libro", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(16.dp))

        Text("Título: ${book.title}")
        Text("Autor: ${book.author}")
        Text("Estado: ${book.status}")

        Spacer(Modifier.height(24.dp))
        Row {
            Button(onClick = { navController.navigate("edit/${book.id}") }) {
                Text("Editar")
            }
            Spacer(Modifier.width(16.dp))
            Button(onClick = {
                viewModel.deleteBook(bookId)
                navController.popBackStack()
            }) {
                Text("Eliminar")
            }
        }
    }
}
