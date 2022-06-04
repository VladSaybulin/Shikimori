package ru.ironball.shikimori.ui.screens.animeauthors

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import ru.ironball.shikimori.ui.common.authors.Authors
import ru.ironball.shikimori.ui.common.authors.AuthorsViewState

@Composable
fun AnimeAuthorsScreen(viewModel: AnimeAuthorsViewModel, onNavigateUp: () -> Unit) {

    val viewState by viewModel.viewState.collectAsState(AuthorsViewState.Loading)
    Authors(viewState = viewState, onRefresh = { viewModel.refresh() }, onNavigateUp = onNavigateUp)
}
