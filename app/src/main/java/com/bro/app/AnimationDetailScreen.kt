@file:OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)
package com.bro.app

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.weight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack

@Composable
fun AnimationDetailScreen(index: Int, onBack: () -> Unit) {
    var animate by remember { mutableStateOf(false) }
    // Derive parameters from index to make each animation distinct
    val sizeTarget = if (animate) (50 + (index % 5) * 30).dp else 50.dp
    val rotationTarget = if (animate) (index * 15 % 360).toFloat() else 0f
    val colorTarget = if (animate) listOf(
        Color.Red, Color.Green, Color.Blue, Color.Yellow, Color.Cyan
    )[index % 5] else Color.Gray

    val animatedSize by animateFloatAsState(
        targetValue = sizeTarget.value,
        animationSpec = tween(durationMillis = 800)
    )
    val animatedRotation by animateFloatAsState(
        targetValue = rotationTarget,
        animationSpec = tween(durationMillis = 800)
    )
    val animatedColorFraction by animateFloatAsState(
        targetValue = if (animate) 1f else 0f,
        animationSpec = tween(durationMillis = 800)
    )
    val currentColor = lerp(Color.Gray, colorTarget, animatedColorFraction)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TopAppBar(
            title = { Text(text = "Animation ${index + 1}", fontSize = 20.sp) },
            navigationIcon = {
                IconButton(onClick = onBack) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }
            }
        )
        Spacer(modifier = Modifier.height(32.dp))
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .size(animatedSize.dp)
                    .background(currentColor)
                    .rotate(animatedRotation)
            )
        }
        Button(
            onClick = { animate = !animate },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFBB86FC))
        ) {
            Text(
                text = if (animate) "Reset" else "Animate",
                fontSize = 16.sp,
                color = Color.White
            )
        }
    }
}

// Linear interpolation between two colors
fun lerp(start: Color, stop: Color, fraction: Float): Color {
    val red = start.red + (stop.red - start.red) * fraction
    val green = start.green + (stop.green - start.green) * fraction
    val blue = start.blue + (stop.blue - start.blue) * fraction
    val alpha = start.alpha + (stop.alpha - start.alpha) * fraction
    return Color(red, green, blue, alpha)
}
