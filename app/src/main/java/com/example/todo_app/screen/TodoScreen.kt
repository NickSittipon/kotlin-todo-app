package com.example.todo_app.screen

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.*
import com.example.todo_app.screen.component.*
import com.example.todo_app.viewmodel.TodoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoScreen(viewModel: TodoViewModel) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(Color(0xFFE3F2FD), Color(0xFFBBDEFB)))),
        topBar = {
            TopAppBar(
                title = {
                    Text("Todo App", fontSize = 24.sp, color = Color.White)
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF3F51B5))
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = viewModel::addItem,
                containerColor = Color(0xFF3F51B5)
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {
            OutlinedTextField(
                value = viewModel.newItemText,
                onValueChange = viewModel::onTextChanged,
                label = { Text("Add new task") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(Modifier.height(12.dp))

            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                StatItem(viewModel.todoItems.size, "Total", Color(0xFF3F51B5))
                StatItem(viewModel.todoItems.count { it.isCompleted }, "Completed", Color(0xFF4CAF50))
                StatItem(viewModel.todoItems.count { !it.isCompleted }, "Pending", Color(0xFFFF9800))
            }

            Spacer(Modifier.height(12.dp))

            if (viewModel.todoItems.isEmpty()) {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text("No tasks yet\nTap + to add a new task", textAlign = androidx.compose.ui.text.style.TextAlign.Center)
                }
            } else {
                LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(viewModel.todoItems, key = { it.id }) { item ->
                        AnimatedVisibility(
                            visible = true,
                            enter = slideInVertically() + fadeIn(tween(500)),
                            exit = fadeOut(tween(500))
                        ) {
                            TodoItemRow(
                                item = item,
                                onToggleComplete = { viewModel.toggleItem(item.id) },
                                onDelete = { viewModel.deleteItem(item.id) }
                            )
                        }
                    }
                }
            }
        }
    }
}
