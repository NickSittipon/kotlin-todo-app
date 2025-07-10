package com.example.todo_app.screen.component

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.*

@Composable
fun StatItem(count: Int, label: String, color: Color) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "$count", fontSize = 20.sp, color = color)
        Text(text = label, fontSize = 12.sp, color = Color(0xFF757575))
    }
}
