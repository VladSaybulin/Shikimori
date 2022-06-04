package ru.ironball.shikimori.ui.common.details.blocks

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun RelatedBlock() {
    Box(
        Modifier
            .fillMaxWidth()
            .background(Color.Gray)
            .height(240.dp))
}