package ru.ironball.shikimori.ui.screens.animedetails

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import ru.ironball.shikimori.R
import ru.ironball.shikimori.ui.common.details.Details
import ru.ironball.shikimori.ui.common.details.blocks.*
import ru.ironball.shikimori.ui.screens.animedetails.blocks.*

@Composable
fun AnimeDetails(
    viewModel: AnimeDetailsViewModel,
    openAnimeDetails: (id: Long) -> Unit,
    openCharacters: (id: Long) -> Unit,
    openAuthors: (id: Long) -> Unit,
    navigateUp: () -> Unit,
) {
    val viewState by viewModel.viewState.collectAsState(AnimeDetailsViewState.Loading)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = if (viewState is AnimeDetailsViewState.Show) (viewState as AnimeDetailsViewState.Show).anime.russianOrOriginalName else "",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis) },
                navigationIcon = {
                    IconButton(onClick = navigateUp) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                    }
                },
            )
        }
    ) { paddingValues ->
        Box(Modifier.padding(paddingValues)) {
            when (viewState) {
                AnimeDetailsViewState.Loading -> Refreshing()
                AnimeDetailsViewState.Error -> RefreshError { viewModel.refresh() }
                is AnimeDetailsViewState.Show -> AnimeDetails(
                    viewState as AnimeDetailsViewState.Show,
                    openAnimeDetails = openAnimeDetails,
                    openCharacters = { openCharacters(viewModel.id) },
                    openAuthors = { openAuthors(viewModel.id) }
                )
            }
        }
    }
}

@Composable
private fun Refreshing() {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}

@Composable
private fun RefreshError(onRetry: () -> Unit) {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.error_loading),
            style = MaterialTheme.typography.subtitle1
        )

        Button(onClick = onRetry) {
            Text(text = stringResource(id = R.string.action_retry))
        }
    }
}

@Composable
private fun AnimeDetails(
    viewState: AnimeDetailsViewState.Show,
    openAnimeDetails: (id: Long) -> Unit,
    openCharacters: () -> Unit,
    openAuthors: () -> Unit,
) {

    val anime = viewState.anime
    val roles = viewState.roles
    val similar = viewState.similarAnime

    Details(
        originalName = anime.name,
        russianName = anime.russianName,
        poster = anime.image,
        information = {
            InformationBlock(
                kind = anime.kind,
                episodes = anime.episodes,
                episodesAired = anime.episodesAired,
                durationEpisode = anime.duration,
                status = anime.status,
                dateAired = anime.dateAired,
                dateReleased = anime.dateReleased,
                genres = anime.genres,
                ageRating = anime.ageRating,
            )
        },
        score = if (anime.score > 0) {
            { ScoreBlock(anime.score) }
        } else null,
        publisher = if (anime.studios.isNotEmpty()) {
            { PublisherBlock(anime.studios) }
        } else null,
        description = { DescriptionBlock(anime.description) },
        related = null,//{ RelatedBlock() },
        authors = { AuthorsBlock(roles.mainAuthors, openAuthors = openAuthors) },
        mainCharacters = {
            MainCharactersBlock(
                roles.mainCharacters,
                openCharacters = openCharacters
            )
        },
        screenshots = null,//{ ScreenshotsBlock() },
        videos = null,//{ VideosBlock() },
        similar = if (similar.isNotEmpty()) {
            { SimilarBlock(similar, openSimilar = { }, openAnime = { openAnimeDetails(it.id) }) }
        } else null,
    )
}