package ru.ironball.shikimori.ui.screens.mangadetails

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import ru.ironball.shikimori.R
import ru.ironball.shikimori.ui.common.details.Details
import ru.ironball.shikimori.ui.common.details.blocks.*
import ru.ironball.shikimori.ui.screens.mangadetails.blocks.InformationBlock
import ru.ironball.shikimori.ui.screens.mangadetails.blocks.PublisherBlock
import ru.ironball.shikimori.ui.screens.mangadetails.blocks.SimilarBlock

@Composable
fun MangaDetails(
    viewModel: MangaDetailsViewModel,
    openMangaDetails: (id: Long) -> Unit,
    openCharacters: (id: Long) -> Unit,
    openAuthors: (id: Long) -> Unit,
    navigateUp: () -> Unit,
) {

    val viewState by viewModel.viewState.collectAsState(MangaDetailsViewState.Loading)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = if (viewState is MangaDetailsViewState.Show) (viewState as MangaDetailsViewState.Show).manga.russianOrOriginalName else "",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
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
                MangaDetailsViewState.Loading -> Refreshing()
                MangaDetailsViewState.Error -> RefreshError { viewModel.refresh() }
                is MangaDetailsViewState.Show -> MangaDetails(
                    viewState as MangaDetailsViewState.Show,
                    openAnimeDetails = openMangaDetails,
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
private fun MangaDetails(
    viewState: MangaDetailsViewState.Show,
    openAnimeDetails: (id: Long) -> Unit,
    openCharacters: () -> Unit,
    openAuthors: () -> Unit,
) {

    val manga = viewState.manga
    val roles = viewState.roles
    val similar = viewState.similar

    Details(
        originalName = manga.name,
        russianName = manga.russianName,
        poster = manga.image,
        information = {
            InformationBlock(
                kind = manga.kind,
                volumes = manga.volumes,
                chapters = manga.chapters,
                status = manga.status,
                dateAired = manga.dateAired,
                dateReleased = manga.dateReleased,
                genres = manga.genres,
            )
        },
        score = if (manga.score > 0) {
            { ScoreBlock(manga.score) }
        } else null,
        publisher = if (manga.publishers.isNotEmpty()) {
            { PublisherBlock(manga.publishers) }
        } else null,
        description = { DescriptionBlock(manga.description) },
        related = null,//{ RelatedBlock() },
        authors = { AuthorsBlock(roles.mainAuthors, openAuthors = openAuthors) },
        mainCharacters = {
            MainCharactersBlock(
                roles.mainCharacters,
                openCharacters = openCharacters
            )
        },
        screenshots = null,
        videos = null,
        similar = if (similar.isNotEmpty()) {
            { SimilarBlock(similar, openSimilar = { }, openManga = { openAnimeDetails(it.id) }) }
        } else null,
    )
}