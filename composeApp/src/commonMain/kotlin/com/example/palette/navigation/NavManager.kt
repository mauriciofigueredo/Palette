package com.example.palette.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.palette.views.HomeView
import com.example.palette.views.PaletteView


@Composable
fun NavMannager(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Home){
        composable<Home>{
            HomeView(
                modifier = Modifier,
                navController
            )
        }
        composable<Palette>{ item ->
            val palette = item.toRoute<Palette>()
            PaletteView(
                navController,
                id = palette.id,
                name = palette.name,
                modifier = Modifier,

            )
        }
    }

}