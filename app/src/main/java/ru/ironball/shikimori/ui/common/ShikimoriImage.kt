package ru.ironball.shikimori.ui.common

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
//TODO remove to 'components'
@Composable
fun ShikimoriImage(
    url: String,
    contentDescription: String,
    modifier: Modifier,
    contentScale: ContentScale = ContentScale.Fit
) {
    AsyncImage(
        model = "https://shikimori.one/$url",
        contentDescription = contentDescription,
        modifier = modifier,
        contentScale = contentScale
    )
}

val AspectRatioModifier = Modifier.aspectRatio(5 / 7f)

