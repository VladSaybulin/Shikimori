package ru.ironball.shikimori.ui.screens.ranobecharacters

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import ru.ironball.shikimori.ui.common.characters.CharactersScreen
import ru.ironball.shikimori.ui.common.characters.CharactersViewState

@Composable
fun RanobeCharactersScreen(viewModel: RanobeCharactersViewModel, onNavigateUp: () -> Unit) {
    val viewState by viewModel.viewState.collectAsState(CharactersViewState.Loading)
    CharactersScreen(viewState, onRefresh = { viewModel.refresh() }, onNavigateUp = onNavigateUp)
}