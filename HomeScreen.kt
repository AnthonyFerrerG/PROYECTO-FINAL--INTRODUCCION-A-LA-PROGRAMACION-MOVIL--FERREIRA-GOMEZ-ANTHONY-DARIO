package com.example.booktracker.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.booktracker.BookViewModel

@Composable
fun HomeScreen(navController: NavController, viewModel: BookViewModel) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate("add") }) {
                Text("+")
            }
        }
    ) {
        LazyColumn(contentPadding = it) {
            items(viewModel.books) { book ->
                Column(
                    Modifier
                        .fillMaxWidth()
                        .clickable { navController.navigate("detail/${book.id}") }
                        .padding(16.dp)
                ) {
                    Text(book.title, style = MaterialTheme.typography.titleLarge)
                    Text("Autor: ${book.author}")
                    Text("Estado: ${book.status}")
                }
            }
        }
    }
}
