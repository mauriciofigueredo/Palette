package com.example.palette

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.palette.views.HomeView


@Composable
@Preview
fun App() {
    MaterialTheme(colorScheme = lightColorScheme(
        background = Color.LightGray
    )) {
        HomeView()
    }
}