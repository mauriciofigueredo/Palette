package com.example.palette.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.palette.components.ColorCard
import org.jetbrains.compose.resources.painterResource
import palette.composeapp.generated.resources.Res
import palette.composeapp.generated.resources.palette

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView() {

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Row {
                        Image(
                            painterResource(Res.drawable.palette),
                            contentDescription = "logo",
                            modifier = Modifier.height(25.dp)
                        )
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {},
                containerColor = Color.DarkGray,
                contentColor = Color.White
                ){
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) {
        padding ->
        ContentHomeView(modifier = Modifier.padding(padding))
    }
}

@Composable
fun ContentHomeView(modifier: Modifier){

    Column(modifier) {
        ColorCard(
            hex="#F5733",
            rgb = "234, 234, 456",
            onEdit = {},
            onCopy = {},
            onDelete = {},
            modifier = Modifier.padding(16.dp)
        )
    }
}
