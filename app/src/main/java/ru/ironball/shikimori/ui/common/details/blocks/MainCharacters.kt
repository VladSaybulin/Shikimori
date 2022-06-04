package ru.ironball.shikimori.ui.common.details.blocks

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.ironball.shikimori.R
import ru.ironball.shikimori.domain.entities.person.Person
import ru.ironball.shikimori.ui.common.AspectRatioModifier
import ru.ironball.shikimori.ui.common.ShikimoriImage
import ru.ironball.shikimori.ui.components.Block

@Composable
fun MainCharactersBlock(
    mainCharacters: List<Person>,
    openCharacters: () -> Unit,
) {
    Block(title = stringResource(id = R.string.block_title_main_characters), onMore = openCharacters) {
        Carousel(
            items = mainCharacters,
            modifier = Modifier.fillMaxWidth()
        ) { character ->
            Column(
                modifier = Modifier.width(128.dp).padding(4.dp)
            ) {
                ShikimoriImage(
                    url = character.image.original,
                    contentDescription = character.russianOrOriginalName,
                    modifier = Modifier
                        .fillMaxWidth()
                        .then(AspectRatioModifier),
                    contentScale = ContentScale.FillWidth,
                )
                Text(text = character.russianOrOriginalName, style = MaterialTheme.typography.subtitle1)
            }
        }
    }
}