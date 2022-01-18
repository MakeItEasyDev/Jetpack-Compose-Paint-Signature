package com.jetpack.composepaint

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.ExperimentalComposeUiApi
import com.jetpack.composepaint.signature.ComposePaint
import com.jetpack.composepaint.ui.theme.ComposePaintTheme

class MainActivity : ComponentActivity() {
    @ExperimentalComposeUiApi
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePaintTheme {
                Surface(color = MaterialTheme.colors.background) {
                    ComposePaint()
                }
            }
        }
    }
}














