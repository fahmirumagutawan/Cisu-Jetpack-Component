package com.fahgutawan.cisusurfacewithbottommenu

import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.res.painterResource

data class CisuSurfaceBottomItem(
    val iconId:Int,
    val onClick:() -> Unit,
    val state:MutableState<Boolean>
)
