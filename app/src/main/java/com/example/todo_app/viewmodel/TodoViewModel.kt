package com.example.todo_app.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.example.todo_app.model.TodoItem

class TodoViewModel : ViewModel() {
    var todoItems by mutableStateOf(listOf<TodoItem>())
        private set

    var newItemText by mutableStateOf("")
    private var nextId = 1

    fun addItem() {
        if (newItemText.isNotBlank()) {
            todoItems = todoItems + TodoItem(id = nextId++, text = newItemText.trim())
            newItemText = ""
        }
    }

    fun toggleItem(id: Int) {
        todoItems = todoItems.map {
            if (it.id == id) it.copy(isCompleted = !it.isCompleted) else it
        }
    }

    fun deleteItem(id: Int) {
        todoItems = todoItems.filterNot { it.id == id }
    }

    fun onTextChanged(text: String) {
        newItemText = text
    }
}
