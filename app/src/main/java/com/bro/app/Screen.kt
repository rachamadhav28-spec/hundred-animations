package com.bro.app

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

class Screen {
    data class Detail(val index: Int)
}

@Composable
fun AnimationDetailScreen(detail: Screen.Detail) {
    Column {
        Row {
            Text(text = "Detail index: ${detail.index}")
        }
    }
}