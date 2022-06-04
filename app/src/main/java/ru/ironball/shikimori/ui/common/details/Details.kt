package ru.ironball.shikimori.ui.common.details

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ru.ironball.shikimori.domain.entities.common.Image
import ru.ironball.shikimori.ui.common.ShikimoriImage

@Composable
fun Details(
    originalName: String,
    russianName: String?,
    poster: Image,
    information: @Composable () -> Unit,
    score: (@Composable () -> Unit)?,
    publisher: (@Composable () -> Unit)?,
    description: @Composable () -> Unit,
    related: (@Composable () -> Unit)?,
    authors: (@Composable () -> Unit)?,
    mainCharacters: (@Composable () -> Unit)?,
    screenshots: (@Composable () -> Unit)?,
    videos: (@Composable () -> Unit)?,
    similar: (@Composable () -> Unit)?,
) {
    CompactDetails(
        originalName = originalName,
        russianName = russianName,
        poster = poster,
        information = information,
        score = score,
        publisher = publisher,
        description = description,
        related = related,
        persons = authors,
        mainCharacters = mainCharacters,
        screenshots = screenshots,
        videos = videos,
        similar = similar
    )
}

@Composable
private fun CompactDetails(
    originalName: String,
    russianName: String?,
    poster: Image,
    information: @Composable () -> Unit,
    score: (@Composable () -> Unit)?,
    publisher: (@Composable () -> Unit)?,
    description: @Composable () -> Unit,
    related: (@Composable () -> Unit)?,
    persons: (@Composable () -> Unit)?,
    mainCharacters: (@Composable () -> Unit)?,
    screenshots: (@Composable () -> Unit)?,
    videos: (@Composable () -> Unit)?,
    similar: (@Composable () -> Unit)?,
) {

    Column(
        Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = if (russianName != null) "$russianName/$originalName" else originalName,
            style = MaterialTheme.typography.h5
        )
        Box(
            Modifier
                .fillMaxWidth()
                .padding(16.dp), contentAlignment = Alignment.Center) {
            ShikimoriImage(
                url = poster.original,
                contentDescription = originalName,
                modifier = Modifier.fillMaxWidth(0.6f),
                contentScale = ContentScale.FillWidth
            )
        }
        information()
        publisher?.let { it() }
        score?.let { it() }
        description()
        related?.let { it() }
        persons?.let { it() }
        mainCharacters?.let { it() }
        screenshots?.let { it() }
        videos?.let { it() }
        similar?.let { it() }
    }

}

@Composable
private fun MediumDetails(
    name: String,
    poster: Image,
    information: @Composable () -> Unit,
    score: (@Composable () -> Unit)?,
    publisher: (@Composable () -> Unit)?,
    description: @Composable () -> Unit,
    related: @Composable () -> Unit,
    persons: @Composable () -> Unit,
    mainCharacters: @Composable () -> Unit,
    screenshots: (@Composable () -> Unit)?,
    videos: (@Composable () -> Unit)?,
    similar: (@Composable () -> Unit)?,
) {
    Column(
        Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = name, style = MaterialTheme.typography.h5)
        Row(Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.fillMaxWidth(0.4f)) {
                AsyncImage(
                    model = "https://shikimori.one/${poster.original}",
                    modifier = Modifier.fillMaxSize(),
                    contentDescription = name,
                    contentScale = ContentScale.FillWidth,
                )
                //TODO Button add to my list
            }
            Spacer(Modifier.width(8.dp))
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                information()
                publisher?.let { it() }
            }
        }
        score?.let { it() }
        description()
        related()
        persons()
        mainCharacters()
        screenshots?.let { it() }
        videos?.let { it() }
        similar?.let { it() }
    }
}