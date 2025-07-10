package com.example.todo_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.remember
import com.example.todo_app.ui.theme.Todo_appTheme
import com.example.todo_app.screen.TodoScreen
import com.example.todo_app.viewmodel.TodoViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Todo_appTheme {
                val viewModel = remember { TodoViewModel() }
                TodoScreen(viewModel)
            }
        }
    }
}
