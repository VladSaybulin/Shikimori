package ru.ironball.shikimori.ui.screens.animedetails.blocks

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
import ru.ironball.shikimori.ui.common.AspectRatioModifier
import ru.ironball.shikimori.ui.common.ShikimoriImage
import ru.ironball.shikimori.ui.components.Block
import ru.ironball.shikimori.ui.common.details.blocks.Carousel
import ru.ironball.shikimori.ui.components.TextWithLines

@OptIn(ExperimentalTextApi::class)
@Composable
fun SimilarBlock(
    similar: List<Anime>,
    openSimilar: () -> Unit,
    openAnime: (Anime) -> Unit
) {
    Block(
        title = stringResource(id = R.string.block_title_similar),
        onMore = if (similar.size > 15) openSimilar else null
    ) {
        Carousel(
            items = similar.subList(0, minOf(similar.size, 15)),
            modifier = Modifier.fillMaxWidth()
        ) { anime ->
            Column(
                modifier = Modifier
                    .width(128.dp)
                    .clickable { openAnime(anime) }
                    .padding(4.dp)
            ) {
                ShikimoriImage(
                    url = anime.image.original,
                    contentDescription = anime.russianOrOriginalName,
                    modifier = Modifier
                        .fillMaxWidth()
                        .then(AspectRatioModifier),
                    contentScale = ContentScale.FillWidth,
                )
                TextWithLines(
                    text = anime.russianOrOriginalName,
                    style = MaterialTheme.typography.subtitle1,
                    lines = 2
                )
            }
        }
    }
}
