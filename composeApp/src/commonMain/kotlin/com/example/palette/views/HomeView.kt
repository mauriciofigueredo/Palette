package com.example.palette.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowCircleRight
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.palette.components.IconTitle
import com.example.palette.components.ModalPalette
import com.example.palette.model.PaletteModel
import com.example.palette.navigation.Palette
import com.example.palette.viewModels.PaletteViewModel
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel
import palette.composeapp.generated.resources.Res
import palette.composeapp.generated.resources.palette

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(modifier : Modifier, navController: NavController) {
    val viewModel = koinViewModel<PaletteViewModel>()
    var showModal by remember { mutableStateOf(false) }
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
                },
                actions = {
                    IconButton(onClick = {showModal=true}){
                        Icon(Icons.Default.Add, contentDescription = "Add")
                    }
                },
                navigationIcon = {
                    //navController.navigate(Palette)
                }
            )

        }
    ) {
        padding ->
        ContentHomeView(navController, modifier = Modifier.padding(padding))
        if(showModal){
            ModalPalette(
                palette = null,
                onDismiss = { showModal = false },
                onSave = {
                    viewModel.insertPalette(it)
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentHomeView(navController: NavController, modifier: Modifier) {
    val viewModel = koinViewModel<PaletteViewModel>()
    val palettes by viewModel.getPalette().collectAsState(null)
    var showModal by remember { mutableStateOf(false) }

    var selectedPalette by remember { mutableStateOf<PaletteModel?>(null)}

    var expanded by remember { mutableStateOf<Int?>(null) }
    LazyColumn(modifier) {
        items(palettes.orEmpty()) { item ->
            HorizontalDivider()
            ListItem(
                headlineContent = {Text(item.name)},
                supportingContent = {Text(item.desc, color = Color.LightGray)},
                leadingContent = {
                    Box(
                        modifier = Modifier.clip(CircleShape)
                    ){
                        IconButton({expanded = item.id}){
                            Icon(Icons.Default.MoreVert, contentDescription = "More")
                        }
                        DropdownMenu(
                            expanded = expanded == item.id,
                            onDismissRequest = { expanded = null},
                            modifier = Modifier.background(color = Color.DarkGray)
                        ){
                            DropdownMenuItem(
                                text = { IconTitle("Edit", Icons.Default.Edit) },
                                onClick = {
                                    expanded = null
                                    selectedPalette = item
                                    showModal = true
                                }
                            )
                            HorizontalDivider()
                            DropdownMenuItem(
                                text = {IconTitle("Delete", Icons.Default.Delete )},
                                onClick = { expanded = null}
                            )
                        }
                    }
                },
                trailingContent = {
                    IconButton(onClick = {}){
                        Icon(Icons.Default.ArrowCircleRight, contentDescription = "next")
                    }
                },
                modifier = Modifier.clickable{
                    navController.navigate(Palette(item.id, item.name))
                }
            )
        }
    }
    if(showModal){
        ModalPalette(
            palette = selectedPalette,
            onDismiss = {},
            onSave = {
                viewModel.updatePalette(it)
            }
        )
    }

}