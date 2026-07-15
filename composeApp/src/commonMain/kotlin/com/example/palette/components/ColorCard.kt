package com.example.palette.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.FileCopy
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun ColorCard(
    hex: String,
    rgb: String,
    onEdit: ()-> Unit,
    onCopy: ()-> Unit,
    onDelete: ()-> Unit,
    modifier: Modifier){

    val color = Color(color = hex.removePrefix("#").toLong(radix=16) or 0xFF000000)
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),

        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(modifier){
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(color),
                contentAlignment = Alignment.Center
            ){
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .clip(RoundedCornerShape(12.dp)),
                    horizontalArrangement = Arrangement.SpaceBetween

                ){
                    Text(text = hex, color = Color.White, fontWeight = FontWeight.Bold)
                    Text(text = hex, color = Color.White, fontWeight = FontWeight.Bold)

                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onEdit){
                    Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit" )
                }
                IconButton(onCopy){
                    Icon(imageVector = Icons.Default.FileCopy, contentDescription = "Copy" )
                }
                IconButton(onDelete){
                    Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete" )
                }
            }
        }
    }

}