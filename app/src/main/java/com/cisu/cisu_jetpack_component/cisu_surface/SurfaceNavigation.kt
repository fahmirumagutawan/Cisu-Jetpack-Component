package com.cisu.cisu_jetpack_component.cisu_surface

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.cisu.cisusplash.util.Black

@Composable
fun MySurfaceNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "a") {
        composable(route = "a") {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color(0xFF7FFFA9)),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "HALAMAN A", color = Black)
            }
        }
        composable(route = "b") {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color(0xFFFDED82)),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "HALAMAN B", color = Black)
            }
        }
        composable(route = "c") {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color(0xFFFFA9A7)),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "HALAMAN C", color = Black)
            }
        }
    }
}