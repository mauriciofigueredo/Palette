package com.example.palette.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CopyAll
import androidx.compose.material.icons.filled.Restore
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.palette.components.ColorCard
import com.example.palette.components.SliderMain
import com.example.palette.copyToClipboard
import com.example.palette.viewModels.ColorViewModel
import org.jetbrains.compose.resources.painterResource
import palette.composeapp.generated.resources.Res
import palette.composeapp.generated.resources.palette

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(modifier : Modifier, viewModel : ColorViewModel = viewModel { ColorViewModel() }) {

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
                    IconButton(onClick = {viewModel.copyAll()}){
                        Icon(Icons.Default.CopyAll, contentDescription = "CopyAll")
                    }
                },
                navigationIcon = {
                    IconButton(onClick = {viewModel.reset()}){
                        Icon(Icons.Default.Restore, contentDescription = "Reset")
                    }
                }
            )

        },
        floatingActionButton = {
            FloatingActionButton(onClick = { viewModel.generateColor()},
                containerColor = Color.DarkGray,
                contentColor = Color.White
                ){
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) {
        padding ->
        ContentHomeView(modifier = Modifier.padding(padding), viewModel)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentHomeView(modifier: Modifier, viewModel: ColorViewModel ){

    val colors by viewModel.colors.collectAsState()

    val modalState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )

    var showModal by remember { mutableStateOf(false)}

    var red by remember {mutableStateOf(0f)}
    var green by remember {mutableStateOf(0f)}
    var blue by remember {mutableStateOf(0f)}
    var id by remember {mutableStateOf(0)}

    LazyColumn(modifier){
        items(colors){color ->
            ColorCard(
                hex=color.hex,
                rgb = color.rgb,
                onEdit = {
                    red = color.red.toFloat()
                    green = color.green.toFloat()
                    blue = color.blue.toFloat()
                    id = color.id
                    showModal = true
                },
                onCopy = {
                    copyToClipboard(color.hex)
                },
                onDelete = {
                    viewModel.deleteColor(color.id)
                },
                modifier = Modifier.padding(16.dp)
            )
        }
    }

    if(showModal){

        ModalBottomSheet(
            onDismissRequest = { showModal = false},
            sheetState = modalState,
            modifier = Modifier.padding(15.dp)
        ){
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Editar color", fontWeight = FontWeight.Bold, fontSize = 25.sp)
                Spacer(modifier = Modifier.height(20.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .clip(CircleShape)
                        .shadow(elevation = 12.dp)

                        .background(Color(red.toInt(),green.toInt(),blue.toInt()))


                )
                Spacer(modifier = Modifier.height(20.dp))

                SliderMain(
                    red,
                    onValueChange = {red = it},
                    color = Color.Red)
                Spacer(modifier = Modifier.height(20.dp))
                SliderMain(
                    green,
                    onValueChange = {green = it},
                    color = Color.Green)
                Spacer(modifier = Modifier.height(20.dp))
                SliderMain(
                    blue,
                    onValueChange = {blue = it},
                    color = Color.Blue)
                Spacer(modifier = Modifier.height(20.dp))

                OutlinedButton(onClick = {
                    viewModel.editColor(id,red.toInt(),green.toInt(),blue.toInt())
                    showModal = false
                }){
                    Text("Change Color", fontWeight = FontWeight.Bold)
                }
            }

        }
    }
}
