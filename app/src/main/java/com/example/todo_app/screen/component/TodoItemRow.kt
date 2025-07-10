package com.example.todo_app.screen.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todo_app.model.TodoItem

@Composable
fun TodoItemRow(
    item: TodoItem,
    onToggleComplete: () -> Unit,
    onDelete: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(4.dp, RoundedCornerShape(12.dp))
            .clickable { onToggleComplete() },
        colors = CardDefaults.cardColors(
            containerColor = if (item.isCompleted) Color(0xFFE8F5E9) else Color.White
        )
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = item.isCompleted,
                onCheckedChange = { onToggleComplete() },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color(0xFF4CAF50),
                    checkmarkColor = Color.White
                )
            )

            Spacer(Modifier.width(12.dp))

            Text(
                text = item.text,
                modifier = Modifier.weight(1f),
                fontSize = 16.sp,
                textDecoration = if (item.isCompleted) TextDecoration.LineThrough else TextDecoration.None,
                color = if (item.isCompleted) Color(0xFF757575) else Color(0xFF212121)
            )

            IconButton(onClick = onDelete) {
                Icon(Icons.Default.Delete, contentDescription = null, tint = Color(0xFFE57373))
            }
        }
    }
}
