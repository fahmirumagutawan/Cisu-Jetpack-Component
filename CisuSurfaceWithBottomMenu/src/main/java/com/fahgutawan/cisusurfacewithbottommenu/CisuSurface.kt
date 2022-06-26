package com.fahgutawan.cisusurfacewithbottommenu

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CisuSurface(
    bottomMenuHeight: Dp = 64.dp,
    bottomMenuColor: Color = Color.White,
    bottomMenuIconPadding: Dp = 16.dp,
    bottomMenuItemDefaultColor: Color = Color.Black,
    bottomMenuItemClickedColor: Color = Color.Gray,
    bottomMenuItemHeightClicked: Dp = 48.dp,
    bottomMenuItemHeightDefault: Dp = 24.dp,
    listOfBottomMenuItem: List<CisuSurfaceBottomItem>? = null,
    content: @Composable () -> Unit
) {
    /**INSTANTIATE SECTION*/
    val listOfIconId = ArrayList<Int>()
    val listOfOnClick = ArrayList<Unit>()
    val listOfState = ArrayList<MutableState<Boolean>>()
    val tmpDp = ArrayList<Dp>()
    val listOfAnimateDp = ArrayList<State<Dp>>()
    val resetState: () -> Unit = {
        listOfState.forEach { state ->
            state.value = false
        }
    }

    if (listOfBottomMenuItem != null) {
        listOfBottomMenuItem.forEach { menuItem ->
            listOfIconId.add(menuItem.iconId)
            listOfOnClick.add(menuItem.onClick())
            listOfState.add(menuItem.state)
            tmpDp.add(bottomMenuItemHeightDefault)
        }

        /**Run Listener for DP Animate & Instantiate our listOfAnimateDp*/
        for (i in 0..tmpDp.size - 1) {
            if (listOfState.get(i).value == true) tmpDp.set(
                i,
                bottomMenuItemHeightClicked
            ) else tmpDp.set(i, bottomMenuItemHeightDefault)
            listOfAnimateDp.add(animateDpAsState(targetValue = tmpDp.get(i)))
        }
    }


    /**COMPOSABLE SECTION*/
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        /**Content here*/
        Surface(modifier = Modifier.fillMaxSize()) {
            content()
        }

        /**Bottom Navigation Menu here*/
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(bottomMenuColor)
                .height(bottomMenuHeight)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = (bottomMenuHeight.value / 16).dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            for (i in 0..listOfIconId.size - 1) {
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(color = bottomMenuColor),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        modifier = Modifier
                            .padding(bottomMenuIconPadding)
                            .size(listOfAnimateDp.get(i).value),
                        painter = painterResource(id = listOfIconId.get(i)),
                        contentDescription = "Bottom Menu Icon",
                        tint = if (listOfState.get(i).value) bottomMenuItemClickedColor else bottomMenuItemDefaultColor
                    )
                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(bottomMenuItemHeightDefault * 2)
                            .clickable(
                                interactionSource = MutableInteractionSource(),
                                indication = rememberRipple(bounded = true, color = Color.Black),
                                onClick = {
                                    resetState()
                                    listOfState.get(i).value = true
                                })
                    )
                }
            }
        }
    }
}