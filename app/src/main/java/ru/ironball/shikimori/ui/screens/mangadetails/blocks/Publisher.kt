package ru.ironball.shikimori.ui.screens.mangadetails.blocks

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.ironball.shikimori.R
import ru.ironball.shikimori.domain.entities.anime.Studio
import ru.ironball.shikimori.domain.entities.manga.Publisher
import ru.ironball.shikimori.ui.common.ShikimoriImage
import ru.ironball.shikimori.ui.components.Block

@Composable
fun PublisherBlock(publishers: List<Publisher>) {
    Block(title = stringResource(id = R.string.block_title_publisher)) {
        Column(
            Modifier
                .padding(it)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            publishers.forEach { publisher ->
                Text(text = publisher.name, style = MaterialTheme.typography.subtitle1)
            }
        }
    }
}