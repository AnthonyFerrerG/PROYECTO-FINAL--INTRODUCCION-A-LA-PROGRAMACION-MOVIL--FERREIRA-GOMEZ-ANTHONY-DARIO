package com.example.booktracker.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.booktracker.BookViewModel

@Composable
fun AddBookScreen(navController: NavController, viewModel: BookViewModel) {
    var title by remember { mutableStateOf("") }
    var author by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("Por leer") }

    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Text("Agregar Libro", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(16.dp))

        OutlinedTextField(value = title, onValueChange = { title = it }, label = { Text("Título") })
        OutlinedTextField(value = author, onValueChange = { author = it }, label = { Text("Autor") })

        DropdownMenuStatus(status) { status = it }

        Spacer(Modifier.height(16.dp))
        Button(onClick = {
            if (title.length >= 3 && author.isNotEmpty()) {
                viewModel.addBook(title, author, status)
                navController.popBackStack()
            }
        }) {
            Text("Guardar")
        }
    }
}
