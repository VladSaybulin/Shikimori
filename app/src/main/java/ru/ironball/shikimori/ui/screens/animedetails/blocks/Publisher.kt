package ru.ironball.shikimori.ui.screens.animedetails.blocks

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
import ru.ironball.shikimori.ui.common.ShikimoriImage
import ru.ironball.shikimori.ui.components.Block

@Composable
fun PublisherBlock(studios: List<Studio>) {
    Block(title = stringResource(id = R.string.block_title_studio)) {
        Column(
            Modifier
                .padding(it)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            studios.forEach { studio ->
                if (studio.image != null) {
                    ShikimoriImage(
                        url = studio.image,
                        contentDescription = studio.name,
                        modifier = Modifier
                            .width(240.dp)
                            .sizeIn(maxHeight = 120.dp)
                    )
                } else {
                    Text(text = studio.name, style = MaterialTheme.typography.subtitle1)
                }
            }
        }
    }
}