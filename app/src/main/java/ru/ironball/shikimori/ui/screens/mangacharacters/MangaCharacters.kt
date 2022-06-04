package ru.ironball.shikimori.ui.screens.mangacharacters

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import ru.ironball.shikimori.ui.common.characters.CharactersScreen
import ru.ironball.shikimori.ui.common.characters.CharactersViewState

@Composable
fun MangaCharactersScreen(viewModel: MangaCharactersViewModel, onNavigateUp: () -> Unit) {
    val viewState by viewModel.viewState.collectAsState(CharactersViewState.Loading)
    CharactersScreen(viewState, onRefresh = { viewModel.refresh() }, onNavigateUp = onNavigateUp)
}