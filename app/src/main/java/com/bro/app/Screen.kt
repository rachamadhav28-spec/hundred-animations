package com.bro.app

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.weight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AnimationDetailScreen(detail: Screen.Detail) {
    Column {
        Row(
            modifier = Modifier.weight(1f)
        ) {
            Text(text = "Detail index: ${detail.index}")
        }
    }
}