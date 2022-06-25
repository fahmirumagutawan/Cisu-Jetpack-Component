package com.cisu.cisu_jetpack_component

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.cisu.cisu_jetpack_component.ui.theme.CisuJetpackComponentTheme
import com.cisu.cisusplash.CisuSplash

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

                    CisuSplash()
                        .setDefaultSize(80.dp)
                        .setZoomedSize(240.dp)
                        .build(rememberCoroutineScope())

                }
            }
        }
    }
}