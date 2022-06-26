package com.cisu.cisu_jetpack_component

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.cisu.cisu_jetpack_component.ui.theme.CisuJetpackComponentTheme
import com.fahgutawan.cisusurfacewithbottommenu.CisuSurfaceBottomItem
import com.fahgutawan.cisusurfacewithbottommenu.CisuSurface

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CisuJetpackComponentTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

//                    //SPLASH
//                    CisuSplash()
//                        .setDefaultSize(80.dp)
//                        .setZoomedSize(240.dp)
//                        .isCircleBackround(true, contentPadding = 2.dp)
//                        .build(rememberCoroutineScope())

                    /**CISU Surface*/
                    val listItem = listOf(
                        CisuSurfaceBottomItem(
                            iconId = R.drawable.ic_test_botmenuitem,
                            onClick = {

                            },
                            state = remember { mutableStateOf(true) }
                        ),
                        CisuSurfaceBottomItem(
                            iconId = R.drawable.ic_test_botmenuitem,
                            onClick = {

                            },
                            state = remember { mutableStateOf(false) }
                        ),
                        CisuSurfaceBottomItem(
                            iconId = R.drawable.ic_test_botmenuitem,
                            onClick = {

                            },
                            state = remember { mutableStateOf(false) }
                        ),
                        CisuSurfaceBottomItem(
                            iconId = R.drawable.ic_test_botmenuitem,
                            onClick = {

                            },
                            state = remember { mutableStateOf(false) }
                        )
                    )
                    CisuSurface(
                        bottomMenuColor = Color(0xFFF7F2A8),
                        listOfBottomMenuItem = listItem
                    ) {

                    }
                }
            }
        }
    }
}