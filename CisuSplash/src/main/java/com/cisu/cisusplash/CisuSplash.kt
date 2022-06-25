package com.cisu.cisusplash

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.Unspecified
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.cisu.cisusplash.util.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CisuSplash {
    private var bg = Unspecified
    private var listOfTint = listOf(YellowLight, Yellow, YellowDarker, Transparent)
    private var logo = R.drawable.ic_explore
    private var iconShadow = R.drawable.ic_shadow
    private var defaultSize = 64.dp
    private var zoomedSize = 100.dp
    private var isShadowStill = true
    private var shadowDuration = 300L
    private var composeAbove: @Composable Unit? = null
    private var composeBelow: @Composable Unit? = null
    private var isCircleBackground = false
    private var insideCirclePadding = 0.dp
    private var circleBackgroundColor = Gray

    fun setBackground(color: Color) = apply {
        this.bg = color
    }

    fun setTints(listOfTint: List<Color>) = apply {
        //Why we set condition like this?
        //Because if shadow setted to "disappear", then all of it will disappear before last shadow has animated
        //So we have to add a dummy shadow, as u see it's transparent color
        if (isShadowStill) {
            this.listOfTint = listOfTint + Transparent
        } else {
            this.listOfTint = listOfTint + Transparent
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

    fun setShadowIcon(iconId: Int) = apply {
        iconShadow = iconId
    }

    fun isCircleBackround(isCircle: Boolean, contentPadding: Dp = 0.dp, color: Color = Gray) = apply {
        isCircleBackground = isCircle
        insideCirclePadding = contentPadding
        circleBackgroundColor = color
    }

    fun setDurationPerShadow(duration:Long) = apply {
        shadowDuration = duration
    }

    fun addComposeAbove(compose: @Composable Unit) = apply {
        composeAbove = compose
    }

    fun addComposeBelow(compose: @Composable Unit) = apply {
        composeBelow = compose
    }

    @SuppressLint(
        "CoroutineCreationDuringComposition", "RememberReturnType"
    )
    @Composable
    fun build(scope: CoroutineScope) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = bg),
            contentAlignment = Alignment.Center
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (composeAbove != null) composeAbove


                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(bg), contentAlignment = Alignment.Center){
                    Box(contentAlignment = Alignment.Center) {
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
                                val zoomDiff = ((zoomedSize - defaultSize) / listOfTint.size)

                                for (i in 0..listOfTint.size - 1) {
                                    delay(shadowDuration)
                                    listOfDp.set(i, (zoomedSize - ((i+1) * zoomDiff.value).dp))
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
                            Icon(
                                modifier = Modifier.size(animateDpAsState(targetValue = listOfDp.get(i)).value),
                                painter = painterResource(id = iconShadow),
                                contentDescription = "My ICON",
                                tint = listOfTint.get(i)
                            )


                            if (i == listOfTint.size - 1) {
                                isRendered = true
                            }
                        }
                    }
                    Box(modifier = Modifier.size(defaultSize), contentAlignment = Alignment.Center){
                        Icon(
                            modifier = Modifier.size(defaultSize),
                            painter = painterResource(id = R.drawable.ic_shadow),
                            contentDescription = "My ICON",
                            tint = circleBackgroundColor
                        )
                        Image(
                            modifier = Modifier.size(defaultSize-(insideCirclePadding*2)),
                            painter = painterResource(id = logo),
                            contentDescription = "My Logo"
                        )
                    }
                }


                if (composeBelow != null) composeBelow
            }

        }
    }
}