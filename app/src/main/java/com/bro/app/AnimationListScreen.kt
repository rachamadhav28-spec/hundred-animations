@file:OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)
package com.bro.app

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AnimationListScreen(onItemClick: (Int) -> Unit) {
    Column {
        TopAppBar(
            title = { Text(text = "100 Animations", fontSize = 20.sp) }
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            itemsIndexed(List(100) { index -> "Animation ${index + 1}" }) { idx, title ->
                Text(
                    text = title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onItemClick(idx) }
                        .padding(vertical = 12.dp, horizontal = 8.dp),
                    fontSize = 16.sp,
                    color = Color.White
                )
            }
        }
    }
}
