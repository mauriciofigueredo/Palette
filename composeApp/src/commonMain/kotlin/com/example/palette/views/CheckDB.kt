package com.example.palette.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.palette.model.PaletteModel
import com.example.palette.viewModels.PaletteViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun CheckDB(modifier: Modifier = Modifier){
    val viewModel = koinViewModel<PaletteViewModel>()
    val palettes by viewModel.getPalette().collectAsState(null)

    Column(modifier = Modifier.padding(50.dp)) {
        Text("Test")
        Button(onClick = {
            val x = PaletteModel(name = "Paleta1", desc = "Descripcion")
            viewModel.insertPalette(x)
        }){
            Text("Agregar")
        }
        Spacer(modifier = Modifier.height(20.dp))
        LazyColumn {
            items(palettes.orEmpty()){ item ->
                Text(item.name)

            }
        }
    }
}