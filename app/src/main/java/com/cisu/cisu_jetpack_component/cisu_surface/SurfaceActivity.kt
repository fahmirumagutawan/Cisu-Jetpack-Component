package com.cisu.cisu_jetpack_component.cisu_surface

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.cisu.cisu_jetpack_component.R
import com.fahgutawan.cisusurfacewithbottommenu.CisuSurface
import com.fahgutawan.cisusurfacewithbottommenu.CisuSurfaceBottomItem

@Composable
fun MySurfaceActivity() {
    val navController = rememberNavController()
    val listOfItem = listOf(
        CisuSurfaceBottomItem(
            iconId = R.drawable.ic_circle,
            state = remember{ mutableStateOf(true)},
            onClick = {
                navController.navigate(route = "a")
            }
        ),
        CisuSurfaceBottomItem(
            iconId = R.drawable.ic_circle,
            state = remember{ mutableStateOf(false)},
            onClick = {
                navController.navigate(route = "b")
            }
        ),CisuSurfaceBottomItem(
            iconId = R.drawable.ic_circle,
            state = remember{ mutableStateOf(false)},
            onClick = {
                navController.navigate(route = "c")
            }
        )
    )

    CisuSurface(
        bottomMenuColor = Color(0xFFA7BDFF),
        listOfBottomMenuItem = listOfItem
    ) {
        MySurfaceNavigation(navController = navController)
    }
}