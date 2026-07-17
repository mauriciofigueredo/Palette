package com.example.palette.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun IconTitle(
    title: String,
    icon: ImageVector
){
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(icon, title, tint = Color.White)
        Spacer(modifier = Modifier.padding(4.dp))
        Text(title, color = Color.White)
    }

}