package ru.ironball.shikimori.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun <T : Any> Grid(
    items: List<T>,
    columns: Int,
    modifier: Modifier = Modifier,
    itemContent: @Composable (T) -> Unit
) {
    Column(modifier) {
        val rows = when {
            items.size % columns == 0 -> items.size / columns
            else -> items.size / columns + 1
        }

        for (row in 0 until rows) {
            Row(modifier = Modifier.fillMaxWidth()) {
                for (column in 0 until columns) {
                    Box(modifier = Modifier.weight(1f)) {
                        val index = row * columns + column
                        if (index < items.size) {
                            itemContent(items[index])
                        }
                    }
                }
            }
        }
    }
}

fun LazyListScope.gridItems(
    count: Int,
    columns: Int,
    itemContent: @Composable LazyItemScope.(Int) -> Unit
) {
    val rows = when {
        count % columns == 0 -> count / columns
        else -> count / columns + 1
    }

    for (row in 0 until rows) {
        item {
            Row(modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min)) {
                for (column in 0 until columns) {
                    Box(modifier = Modifier.weight(1f)) {
                        val index = row * columns + column
                        if (index < count) {
                            itemContent(index)
                        }
                    }
                }
            }
        }
    }
}