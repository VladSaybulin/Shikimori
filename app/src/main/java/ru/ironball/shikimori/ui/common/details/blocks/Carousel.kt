package ru.ironball.shikimori.ui.common.details.blocks

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.chrisbanes.snapper.ExperimentalSnapperApi
import dev.chrisbanes.snapper.SnapOffsets
import dev.chrisbanes.snapper.rememberSnapperFlingBehavior

@OptIn(ExperimentalSnapperApi::class)
@Composable
fun <T : Any> Carousel(
    items: List<T>,
    modifier: Modifier,
    itemContent: @Composable (T) -> Unit,
) {
    val lazyListState = rememberLazyListState()

    LazyRow(
        state = lazyListState,
        modifier = modifier,
        flingBehavior = rememberSnapperFlingBehavior(
            lazyListState = lazyListState,
            snapOffsetForItem = SnapOffsets.Start
        )
    ) {
        items(items) {
            itemContent(it)
        }
    }
}