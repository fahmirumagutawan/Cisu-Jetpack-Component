package com.cisu.cisusplash

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.cisu.cisusplash.util.Black
import com.cisu.cisusplash.util.Blue
import com.cisu.cisusplash.util.Green
import com.cisu.cisusplash.util.Yellow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CisuSplash {
    var bg = Black
    var listOfTint = listOf(Green, Yellow, Blue, Color.Transparent)
    var logo = R.drawable.ic_compass
    var iconShadow = R.drawable.ic_compass
    var defaultSize = 64.dp
    var zoomedSize = 100.dp
    var isShadowStill = true

    fun setBackground(color: Color) = apply {
        this.bg = color
    }

    fun setTints(listOfTint: List<Color>) = apply {
        //Why we set condition like this?
        //Because if shadow setted to "disappear", then all of it will disappear before last shadow has animated
        //So we have to add a dummy shadow, as u see it's transparent color
        if (isShadowStill) {
            this.listOfTint = listOfTint
        } else {
            this.listOfTint = listOfTint + Color.Transparent
        }
    }

    fun setLogo(logoId: Int) = apply {
        this.logo = logoId
    }

    fun setDefaultSize(size: Dp) = apply {
        defaultSize = size
    }

    fun setZoomedSize(size: Dp) = apply {
        zoomedSize = size
    }

    fun setShadowStill(isShadowStill: Boolean) = apply {
        this.isShadowStill = isShadowStill
    }

    fun setShadowIcon(iconId: Int) {
        iconShadow = iconId
    }

    @SuppressLint(
        "CoroutineCreationDuringComposition", "RememberReturnType"
    )
    @Composable
    fun build(scope: CoroutineScope) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            //Have to instantitate individually, so all of shadows has its own Dp & Visibility state.
            val listOfDp = remember {
                mutableStateListOf<Dp>()
            }
            val listOfVisible = remember {
                mutableStateListOf<Boolean>()
            }

            //isRendered var is used to make sure that all the component has to be rendered first before coroutine doing its job
            //this variable will be changed if "rendering loop (coded below)" reach it's last iteration.
            var isRendered by remember {
                mutableStateOf(false)
            }
            for (i in 0..listOfTint.size - 1) {
                listOfDp.add(defaultSize)
                listOfVisible.add(true)

            }

            //We're here using coroutine, because we dont want to each shadow waiting to other shadow moving.
            //So it's can move together by itself
            scope.launch {
                if (isRendered) {
                    var zoomDiff = ((zoomedSize - defaultSize) / listOfTint.size)

                    for (i in 0..listOfTint.size - 1) {
                        delay(300)
                        listOfDp.set(i, zoomedSize - ((i) * zoomDiff.value).dp)
                    }

                    //We didn't make this loop together above, because we don't want to each shadow disappear before next shadow appeared.
                    //So it has to be disappear together after all shadow has animated
                    for (i in 0..listOfTint.size - 1) {
                        listOfVisible.set(i, isShadowStill)
                    }
                }
            }

            //Rendering all the shadow, include the IconImage itself
            for (i in 0..listOfTint.size - 1) {
                AnimatedVisibility(visible = listOfVisible.get(i)) {
                    Icon(
                        modifier = Modifier.size(animateDpAsState(targetValue = listOfDp.get(i)).value),
                        painter = painterResource(id = iconShadow),
                        contentDescription = "My ICON",
                        tint = listOfTint.get(i)
                    )
                }

                if (i == listOfTint.size - 1) {
                    Image(
                        modifier = Modifier.size(defaultSize),
                        painter = painterResource(id = logo),
                        contentDescription = "My Logo"
                    )
                    isRendered = true
                }
            }

        }
    }
}