package ru.ironball.shikimori.ui.common.details.screens

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
import ru.ironball.shikimori.ui.components.Grid

@Composable
fun Characters(
    mainCharacters: List<Person>,
    minorCharacters: List<Person>,
) {
    Column {
        CharacterBlock(
            title = stringResource(id = R.string.block_title_main_characters),
            characters = mainCharacters
        )
        CharacterBlock(
            title = stringResource(id = R.string.block_title_minor_characters),
            characters = minorCharacters
        )
    }

}

@Composable
private fun CharacterBlock(
    title: String,
    characters: List<Person>,
) {
    Block(title = title) { paddingValues ->
        BoxWithConstraints(modifier = Modifier.padding(paddingValues)) {
            val columns = when {
                maxWidth < 480.dp -> 2
                maxWidth < 840.dp -> 4
                else -> 6
            }
            Grid(items = characters, columns = columns) { character ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                ) {
                    ShikimoriImage(
                        url = character.image.original,
                        contentDescription = character.russianOrOriginalName,
                        modifier = Modifier
                            .fillMaxWidth()
                            .then(AspectRatioModifier),
                        contentScale = ContentScale.FillWidth,
                    )
                    Text(
                        text = character.russianOrOriginalName,
                        style = MaterialTheme.typography.subtitle1
                    )
                }
            }
        }
    }
}