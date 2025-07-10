package com.example.todo_app.model

data class TodoItem(
    val id: Int,
    val text: String,
    val isCompleted: Boolean = false
)
