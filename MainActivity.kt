package com.example.booktracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.booktracker.ui.Navigation
import com.example.booktracker.ui.theme.BookTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookTrackerTheme {
                val viewModel: BookViewModel = viewModel()
                Navigation(viewModel)
            }
        }
    }
}
