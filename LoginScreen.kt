package com.example.booktracker.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.booktracker.BookViewModel

@Composable
fun LoginScreen(navController: NavController, viewModel: BookViewModel) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var error by remember { mutableStateOf(false) }

    Column(
        Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("BookTracker", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(20.dp))
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Usuario") }
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(Modifier.height(16.dp))
        Button(onClick = {
            if (viewModel.login(username, password)) {
                navController.navigate("home") { popUpTo("login") { inclusive = true } }
            } else {
                error = true
            }
        }) {
            Text("Ingresar")
        }

        if (error) {
            Text("Credenciales incorrectas", color = MaterialTheme.colorScheme.error)
        }
    }
}
