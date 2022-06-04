package ru.ironball.shikimori.ui.common.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ru.ironball.shikimori.domain.entities.anime.Anime
import ru.ironball.shikimori.domain.entities.common.Image
import ru.ironball.shikimori.domain.entities.manga.Manga
import ru.ironball.shikimori.domain.entities.person.Person
import ru.ironball.shikimori.ui.common.stringByAnimeKind
import ru.ironball.shikimori.ui.common.stringMangaKind
import ru.ironball.shikimori.ui.components.TextWithLines
import java.util.*

@Composable
fun AnimeGridItem(anime: Anime, onClick: (Anime) -> Unit) {
    BaseGridItem(
        name = anime.russianOrOriginalName,
        image = anime.image,
        airedYear = anime.dateAired?.get(Calendar.YEAR)?.toString(),
        kind = stringByAnimeKind(kind = anime.kind)
    ) {
        onClick(anime);
    }
}

@Composable
fun MangaGridItem(manga: Manga, onClick: (Manga) -> Unit) {
    BaseGridItem(
        name = manga.russianOrOriginalName,
        image = manga.image,
        airedYear = manga.dateAired?.get(Calendar.YEAR)?.toString(),
        kind = stringMangaKind(kind = manga.kind)
    ) {
        onClick(manga);
    }
}

@Composable
fun PersonGridItem(person: Person) {
    BaseGridItem(
        name = person.russianOrOriginalName,
        image = person.image,
        airedYear = null,
        kind = null
    ) {  }
}

@OptIn(ExperimentalTextApi::class)
@Composable
private fun BaseGridItem(
    name: String,
    image: Image,
    airedYear: String?,
    kind: String?,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(8.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Poster(
                imageUrl = image.original,
                contentDescription = name,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(PosterAspect)
            )
            Text(
                text = name,
                style = MaterialTheme.typography.h6,
                overflow = TextOverflow.Ellipsis,
                maxLines = 2,
            )
        }

        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            kind?.let { Text(it) }
            airedYear?.let { Text(it) }
        }
    }
}

@Composable
private fun Poster(imageUrl: String, contentDescription: String, modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        AsyncImage(
            model = "https://shikimori.one/$imageUrl",
            contentDescription = contentDescription,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillWidth
        )
    }
}

//Cause cutting out the posters
private const val PosterAspect = 5 / 7f