package com.jetpack.composepaint.signature

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@Composable
fun ComposePaint() {
    val paths = remember { mutableStateOf(mutableListOf<PathState>()) }
    Scaffold(
        topBar = {
            ComposePaintAppBar {
                paths.value = mutableListOf()
            }
        }
    ) {
        PaintBody(paths)
    }
}

@Composable
fun ComposePaintAppBar(
    onDelete: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = "Compose Paint/Signature"
            )
        },
        actions = {
            IconButton(onClick = onDelete) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete"
                )
            }
        }
    )
}

@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@Composable
fun PaintBody(
    paths: MutableState<MutableList<PathState>>
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        val drawColor = remember { mutableStateOf(Color.Black) }
        val drawBrush = remember { mutableStateOf(5f) }
        val usedColors = remember { mutableStateOf(mutableSetOf(Color.Black, Color.White, Color.Gray)) }

        paths.value.add(PathState(Path(), drawColor.value, drawBrush.value))

        DrawingCanvas(
            drawColor,
            drawBrush,
            usedColors,
            paths.value
        )
        DrawingTools(
            drawColor = drawColor,
            drawBrush = drawBrush,
            usedColors = usedColors.value
        )
    }
}














