package ru.ironball.shikimori.ui.screens.mangadetails.blocks

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.unit.dp
import ru.ironball.shikimori.R
import ru.ironball.shikimori.domain.entities.anime.Anime
import ru.ironball.shikimori.domain.entities.manga.Manga
import ru.ironball.shikimori.ui.common.AspectRatioModifier
import ru.ironball.shikimori.ui.common.ShikimoriImage
import ru.ironball.shikimori.ui.components.Block
import ru.ironball.shikimori.ui.common.details.blocks.Carousel
import ru.ironball.shikimori.ui.components.TextWithLines

@OptIn(ExperimentalTextApi::class)
@Composable
fun SimilarBlock(
    similar: List<Manga>,
    openSimilar: () -> Unit,
    openManga: (Manga) -> Unit
) {
    Block(
        title = stringResource(id = R.string.block_title_similar),
        onMore = if (similar.size > 15) openSimilar else null
    ) {
        Carousel(
            items = similar.subList(0, minOf(similar.size, 15)),
            modifier = Modifier.fillMaxWidth()
        ) { manga ->
            Column(
                modifier = Modifier
                    .width(128.dp)
                    .clickable { openManga(manga) }
                    .padding(4.dp)
            ) {
                ShikimoriImage(
                    url = manga.image.original,
                    contentDescription = manga.russianOrOriginalName,
                    modifier = Modifier
                        .fillMaxWidth()
                        .then(AspectRatioModifier),
                    contentScale = ContentScale.FillWidth,
                )
                TextWithLines(
                    text = manga.russianOrOriginalName,
                    style = MaterialTheme.typography.subtitle1,
                    lines = 2
                )
            }
        }
    }
}
