package ru.ironball.shikimori.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ru.ironball.shikimori.ui.theme.AppTheme

@Composable
fun Block(
    title: String,
    onMore: (() -> Unit)? = null,
    content: @Composable (contentPadding: PaddingValues) -> Unit,
) {
    Column(Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .background(AppTheme.colors.secondary)
                .let {
                    if (onMore == null) it else it.clickable(onClick = onMore)
                }
                .padding(start = 8.dp)
                .padding(vertical = 4.dp),
        ) {
            Text(
                text = title,
                maxLines = 1,
                style = MaterialTheme.typography.subtitle1,
                fontWeight = FontWeight.Bold
            )
            onMore?.let {
                Icon(imageVector = Icons.Filled.ArrowRight, contentDescription = null)
            }
        }

        content(PaddingValues(horizontal = 8.dp, vertical = 4.dp))
    }
}